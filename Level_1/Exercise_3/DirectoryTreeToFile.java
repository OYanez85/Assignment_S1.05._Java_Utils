package Exercise_3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryTreeToFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Please provide a directory path and a file path to save the result.");
            return;
        }

        File directory = new File(args[0]);
        File outputFile = new File(args[1]);

        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Error: The provided path is not a valid directory.");
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            listDirectoryTreeToFile(directory, "", writer);
            System.out.println("Directory tree has been saved to " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file - " + e.getMessage());
        }
    }

    public static void listDirectoryTreeToFile(File directory, String indent, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            writer.write("Error: Unable to access directory contents.\n");
            return;
        }

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
