import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

public class Worklist extends JFrame {
    public static int scaleFactor = 1;
   public static int fr=1;
    BufferedImage image;
    JFrame frame = new JFrame();
    ActionListener act= new Listen();
    public Worklist() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 400, height = 400;
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        frame.setSize(400, 500);
        JButton button = new JButton("Сброс изображения");
        button.setVisible(true);
        button.setSize(200, 200);
        button.setActionCommand("reset");
        button.addActionListener(act);
        JButton buttonsave = new JButton("Сохранить изображение");
        buttonsave.setVisible(true);
        buttonsave.setSize(200, 200);
        buttonsave.setActionCommand("save");
        buttonsave.addActionListener(act);
        JLabel label = new JLabel("Фрактал");
        String[] fractals = {
                "Mandelbrot","Tricorn","BurningShip"
        };
        JComboBox box = new JComboBox(fractals);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                box.setActionCommand(box.getSelectedItem().toString());
            }
        });
        box.setActionCommand(box.getSelectedItem().toString());
        box.addActionListener(act);
        pane1.add(button);
        pane1.add(buttonsave);
        pane2.add(label);
        pane2.add(box);
        frame.add(pane1, BorderLayout.SOUTH);
        frame.add(pane2,BorderLayout.NORTH);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(new MouseLocation());
        frame.setVisible(true);    //вывод координат
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Mandelbrot.Mand(image, width, height);
        Repaint rep = new Repaint();
        frame.add(rep.paint(image));
        frame.setVisible(true);}
        class Listen implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "save": {
                        ImageSaver saver = new ImageSaver();
                        saver.SaveImage(image, frame);
                        break;
                    }
                    case "reset": { scaleFactor = 1;
                        Repaint rep = new Repaint();
                        frame.add(rep.paint(image));
                        frame.setVisible(true);
                        System.out.println(scaleFactor);
                        break;
                    }

                    case("Mandelbrot"):{
                        Mandelbrot.Mand(image,image.getWidth(),image.getHeight());
                        fr=1;
                        scaleFactor = 1;
                        Repaint rep = new Repaint();
                        frame.add(rep.paint(image));
                        frame.setVisible(true);
                        System.out.println(fr);
                        break;
                    }
                    case("Tricorn"):{
                        Tricorn.THre(image,image.getWidth(),image.getHeight());
                        fr=2;
                        scaleFactor = 1;
                        Repaint rep = new Repaint();
                        frame.add(rep.paint(image));
                        frame.setVisible(true);
                        System.out.println(fr);
                        break;
                    }
                    case ("BurningShip"):
                        {
                        BurningShip.Burn(image,image.getWidth(),image.getHeight());
                        fr=3;
                            scaleFactor = 1;
                        Repaint rep = new Repaint();
                        frame.add(rep.paint(image));
                        frame.setVisible(true);
                        System.out.println(fr);
                        break;
                    }
                }
            }
        }
    }









