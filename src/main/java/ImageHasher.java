import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by reedtrevelyan on 12/29/15.
 */
public class ImageHasher {

    public static void main(String[] args) {
//        BufferedImage br = toBufferedImage(new ImageIcon("436.JPG").getImage());
        ImageIcon x = new ImageIcon(ImageHasher.class.getResource("436.JPG"));
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}