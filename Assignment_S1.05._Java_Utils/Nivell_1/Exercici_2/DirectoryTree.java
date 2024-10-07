import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryTree {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a directory path.");
            return;
        }
        File directory = new File(args[0]);
        if (directory.isDirectory()) {
            listDirectoryTree(directory, "");
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }

    public static void listDirectoryTree(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
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
}
