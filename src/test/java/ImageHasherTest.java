import org.junit.After;
import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static org.junit.Assert.*;

/**
 * Created by reedt on 1/4/2016.
 */
public class ImageHasherTest {

    @Test
    public void testFileFind() {
        File f = new File("resources/436.jpg");
        assertTrue(f.exists());
        assertNotNull(f);
        assertFalse(new File("/asdf/asdf.djf").exists());
    }

    @Test
    public void testSaveToFile() throws Exception {
        BufferedImage bi = ImageIO.read(new File("resources/436.jpg"));
        assertTrue(ImageHasher.saveToFile(bi, "savedImage", "jpg"));
    }

    @After
    public void cleanUp() {
        if (new File("resources/savedImage.jpg").exists()) {
            try {
                Files.delete(FileSystems.getDefault().getPath(("resources/savedImage.jpg")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}