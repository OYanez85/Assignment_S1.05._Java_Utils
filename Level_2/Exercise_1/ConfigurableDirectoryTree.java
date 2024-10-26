package Exercise_1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class ConfigurableDirectoryTree {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (InputStream input = new FileInputStream("config/config.properties")) {
            config.load(input);
            String directoryPath = config.getProperty("directory");
            String outputPath = config.getProperty("outputFile");

            File directory = new File(directoryPath);
            File outputFile = new File(outputPath);

            try (FileWriter writer = new FileWriter(outputFile)) {
                if (directory.isDirectory()) {
                    listDirectoryTreeToFile(directory, "", writer);
                    System.out.println("Directory tree saved successfully.");
                } else {
                    writer.write("The provided path is not a directory.");
                }
            } catch (IOException e) {
                System.err.println("Error: Failed to write to file - " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error: Failed to load configuration - " + e.getMessage());
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
