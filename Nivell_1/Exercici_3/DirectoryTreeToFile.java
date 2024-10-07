import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryTreeToFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide a directory path and a file path to save the result.");
            return;
        }
        File directory = new File(args[0]);
        File outputFile = new File(args[1]);
        try (FileWriter writer = new FileWriter(outputFile)) {
            if (directory.isDirectory()) {
                listDirectoryTreeToFile(directory, "", writer);
            } else {
                writer.write("The provided path is not a directory.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listDirectoryTreeToFile(File directory, String indent, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                String fileType = file.isDirectory() ? "(D)" : "(F)";
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                writer.write(indent + file.getName() + " " + fileType + " - Last modified: " + lastModified + "\n");
                if (file.isDirectory()) {
                    listDirectoryTreeToFile(file, indent + "  ", writer);
                }
            }
        }
    }
}
