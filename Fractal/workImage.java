import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.*;


public class workImage extends javax.swing.JComponent {
    private float scaleFactor = 1.0F;
    private BufferedImage workspace;

    public workImage() {
        this.setSize(0,0 );
    }

    public void setImage(BufferedImage image) {
        this.workspace = image;
        this.setSize(image.getWidth(), image.getHeight());
        this.repaint();
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        if (this.workspace != null) {
            Graphics2D g2 = (Graphics2D)g;
            int newW = (int)((float)this.workspace.getWidth() * this.scaleFactor);
            int newH = (int)((float)this.workspace.getHeight() * this.scaleFactor);
            this.setPreferredSize(new Dimension(newW, newH));
            this.revalidate();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g2.drawImage(this.workspace, 0, 0, newW, newH, (ImageObserver)null);
        }

    }
}