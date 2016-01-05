import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by reedt on 1/4/2016.
 */
public class FileHasher {
    File file;

    public FileHasher(File file) {
        this.file = file;
    }

    public FileHasher(String filename) {
        if (!filename.contains(".")) {
            throw new IllegalArgumentException("Illegal filename " + filename + " (does not contain extension)");
        }
        this.file = new File(filename);
    }

    /**
     * Saves text to a file. Does not overwrite if the file already exists.
     * @param text Text to write.
     * @return status of the write operation
     */
    public boolean saveToFile(String text) {
        if (file.exists()) {
            throw new IllegalArgumentException("File " + file.getName() + " already exists.");
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(text);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }
}
