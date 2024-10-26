import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptUtility {
    private static final String ALGORITHM = "AES";
    private static final String KEY_FILE = "../../keyfile.key";

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java EncryptDecryptUtility <encrypt/decrypt> <inputFilePath> <outputFilePath>");
            return;
        }

        String operation = args[0];
        String inputFilePath = args[1];
        String outputFilePath = args[2];

        try {
            if (operation.equalsIgnoreCase("encrypt")) {
                SecretKey key = generateKey(); // Generate a new key for encryption
                saveKey(key, KEY_FILE); // Save the key to the keyfile
                byte[] fileContent = readFile(inputFilePath);
                byte[] encryptedData = encrypt(fileContent, key);
                writeFile(outputFilePath, encryptedData);
                System.out.println("File encrypted successfully.");
            } else if (operation.equalsIgnoreCase("decrypt")) {
                SecretKey key = loadKey(KEY_FILE); // Load the key from the keyfile
                byte[] encryptedData = readFile(inputFilePath);
                byte[] decryptedData = decrypt(encryptedData, key);
                writeFile(outputFilePath, decryptedData);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid operation. Use 'encrypt' or 'decrypt'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to generate a key
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // Key size for AES
        return keyGen.generateKey();
    }

    // Method to save the key to a file
    private static void saveKey(SecretKey key, String fileName) throws IOException {
        byte[] encodedKey = key.getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(encodedKey);
        try (FileWriter keyWriter = new FileWriter(fileName)) {
            keyWriter.write(base64Key);
        }
    }

    // Method to load the key from a file
    private static SecretKey loadKey(String fileName) throws IOException {
        String base64Key;
        try (BufferedReader keyReader = new BufferedReader(new FileReader(fileName))) {
            base64Key = keyReader.readLine();
        }
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }

    // Method to encrypt the data
    private static byte[] encrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    // Method to decrypt the data
    private static byte[] decrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    // Utility method to read a file
    private static byte[] readFile(String filePath) throws IOException {
        return java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath));
    }

    // Utility method to write a file
    private static void writeFile(String filePath, byte[] data) throws IOException {
        java.nio.file.Files.write(java.nio.file.Paths.get(filePath), data);
    }
}
