import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Worklist extends JFrame {
    public static int scaleFactor = 1;
    BufferedImage image;
    public Worklist(){JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 400, height = 400;
        frame.setSize(400,500 );
        JButton button= new JButton("Сброс изображения");
        button.setVisible(true);
        button.setLocation(0, 400);
        button.setSize(400, 100);
        frame.add(button);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(new MouseLocation());
        frame.setVisible(true);    //вывод координат
         image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
         Mandelbrot.Mand(image,width,height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                scaleFactor=1;
                JPanel pane = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g;
                        int newW = (int) (image.getWidth());
                        int newH = (int) (image.getHeight());
                        this.setPreferredSize(new Dimension(newW, newH));
                        this.revalidate();
                        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
//RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                        g2.drawImage(image, 0, 0, newW, newH, null);//x y
                        //repaint();

                    }
                };
                frame.add(pane);
                frame.setVisible(true);
                System.out.println(scaleFactor);
            }
        });


        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                int newW = (int) (image.getWidth());
                int newH = (int) (image.getHeight());
                this.setPreferredSize(new Dimension(newW, newH));
                this.revalidate();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
//RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2.drawImage(image, 0, 0, newW, newH, null);//x y
                //repaint();
            }
        };

        frame.add(pane);
        frame.setVisible(true);
    }

}






