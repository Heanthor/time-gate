import org.junit.After;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * Created by reedtrevelyan on 1/5/16.
 */
public class FileHasherTest {

    @After
    public void tearDown() throws Exception {
        if (new File("resources/test.txt").exists()) {
            Files.delete(FileSystems.getDefault().getPath(("resources/test.txt")));
        }
    }

    @Test
    public void testSaveToFile() throws Exception {
        //Test existence of file
        File f = new File("resources/test.txt");
        FileHasher fh = new FileHasher(f);
        assertFalse(f.exists());

        fh.saveToFile("Hello world\nGoodbye world");

        assertTrue(f.exists());

        // Test contents of file
        BufferedReader br = new BufferedReader(new FileReader(f));

        String line;
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        while ((line = br.readLine()) != null) {
            sj.add(line);
        }

        assertEquals("Hello world\nGoodbye world", sj.toString());

        br.close();
    }
}