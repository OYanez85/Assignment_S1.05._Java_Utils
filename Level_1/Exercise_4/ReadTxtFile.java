package Exercise_4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtFile {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please provide the path of the TXT file to read.");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Error: The specified file does not exist or is not accessible.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Failed to read file - " + e.getMessage());
        }
    }
}
