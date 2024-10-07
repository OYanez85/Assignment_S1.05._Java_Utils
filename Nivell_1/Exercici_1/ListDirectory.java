import java.io.File;
import java.util.Arrays;

public class ListDirectory {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a directory path.");
            return;
        }
        File directory = new File(args[0]);
        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                Arrays.sort(files);
                for (String file : files) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}
