import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ImageSaver {
    public void SaveImage(BufferedImage image,JFrame frame){

        JFileChooser chooser=new JFileChooser() ;
        FileNameExtensionFilter filt=new FileNameExtensionFilter("PNG Images","png");
        chooser.setFileFilter(filt);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showSaveDialog(frame);
       try {
           ImageIO.write(image, "PNG", chooser.getSelectedFile());
       }
       catch(IOException ex){JOptionPane.showMessageDialog(frame ,"cant Save image","Error",JOptionPane.ERROR_MESSAGE);

       }
    }
}
