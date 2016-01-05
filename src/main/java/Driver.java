import java.io.File;
import java.util.StringJoiner;

/**
 * Created by reedt on 1/4/2016.
 */
public class Driver {
    private static final String HELP = "Usage: -hash [absolute path] or -check [absolute path]";

    public static void main(String[] args) {
        // New hash
        if (args.length > 0) switch (args[0]) {
            case "-hash":
                File toHash = parseInput(args, "No file specified to hash\n" + HELP);
                if (toHash == null) System.exit(1);

                // Handle input
                break;

            // Check status
            case "-check":
                File toCheck = parseInput(args, "No file specified to check\n" + HELP);
                if (toCheck == null) System.exit(1);

                // Handle input
                break;

            // Invalid first command
            default:
                System.out.println("Invalid argument\n" + HELP);
                System.exit(1);
        }
        else {
            System.out.println("Not enough args\n" + HELP);
            System.exit(1);
        }
    }

    private static File parseInput(String[] args, String errorMessage) {
        if (args.length < 2) {
            System.out.println(errorMessage);
            return null;
        }
        //Account for filepaths with spaces
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 1; i < args.length; i++) {
            sj.add(args[i]);
        }

        String filePath = sj.toString();
        File toReturn = new File(filePath);

        if (!toReturn.exists()) {
            System.out.println("File " + filePath + " does not exist");
            return null;
        }

        return toReturn;
    }
}
