package Exercise_2;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryTree {
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

        listDirectoryTree(directory, "");
    }

    public static void listDirectoryTree(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.err.println("Error: Unable to access directory contents.");
            return;
        }

        Arrays.sort(files);
        for (File file : files) {
            String fileType = file.isDirectory() ? "(D)" : "(F)";
            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
            System.out.println(indent + file.getName() + " " + fileType + " - Last modified: " + lastModified);

            if (file.isDirectory()) {
                listDirectoryTree(file, indent + "  ");
            }
        }
    }
}
