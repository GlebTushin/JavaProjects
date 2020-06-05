import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MouseLocation extends JPanel {
    private static int xPosition;
    private static int yPosition;
    int width = 400, height = 400;
    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


    public MouseLocation() {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                xPosition = e.getX();
                yPosition = e.getY();
                repaint();
                Mandelbrot.Mand(image,width,height);
                Worklist.scaleFactor++;
                JPanel pane = new JPanel() {
                };
            }
        });


    }
    public static int xCoord(){
        return xPosition;
    }
    public static int yCoord(){
        return yPosition;
    }

    @Override
    public  void paintComponent(Graphics g) {
        //scaleFactor=Main.scaleFactor;
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int newW = (int) (image.getWidth() * Worklist.scaleFactor);
        int newH = (int) (image.getHeight() * Worklist.scaleFactor);
        this.setPreferredSize(new Dimension(newW, newH));
        this.revalidate();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
//RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(image, xPosition*(-1), yPosition*(-1), newW, newH, null);
        //Main.button.setVisible(true);
        System.out.println(Worklist.scaleFactor);
    }
}
