import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by rtrev on 12/29/15.
 */
public class ImageHasher extends FileHasher{

    public ImageHasher(File f) {
        super(f);
    }

    /**
     * @param i RenderedImage to save, such as a BufferedImage
     * @param filename Name to give the file (sans extension) e.g. "image01"
     * @param format Extension to give the file e.g. "png"
     * @return Success or failure of save operation
     */
    public static boolean saveToFile(RenderedImage i, String filename, String format) {
        if (format.contains(".")) {
            throw new IllegalArgumentException("Format string format incorrect");
        }

        if (filename.contains(".")) {
            throw new IllegalArgumentException("Filename format incorrect");
        }

        try {
            return ImageIO.write(i, format, new File(filename + "." + format));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}