package Exercise_1;
import java.io.File;
import java.util.Arrays;

public class ListDirectory {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please provide a directory path.");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Error: The provided path is not a valid directory.");
            return;
        }

        String[] files = directory.list();
        if (files == null) {
            System.err.println("Error: Unable to access directory contents.");
            return;
        }

        Arrays.sort(files);
        for (String file : files) {
            System.out.println(file);
        }
    }
}
