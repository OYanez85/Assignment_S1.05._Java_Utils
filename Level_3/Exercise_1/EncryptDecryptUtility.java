package Exercise_1;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptDecryptUtility {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: EncryptDecryptUtility <inputFile> <outputFile> <encrypt/decrypt>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String operation = args[2];

        try {
            if ("encrypt".equalsIgnoreCase(operation)) {
                encryptFile(inputFile, outputFile);
                System.out.println("File encrypted successfully.");
            } else if ("decrypt".equalsIgnoreCase(operation)) {
                decryptFile(inputFile, outputFile);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid operation. Use 'encrypt' or 'decrypt'.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void encryptFile(String inputFile, String outputFile) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, read);
            }
        }
    }

    private static void decryptFile(String inputFile, String outputFile) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
        }
    }

    private static Key generateKey() throws Exception {
        String keyStr = "1234567890123456"; // Example key, replace with secure key management in production
        return new SecretKeySpec(keyStr.getBytes(), "AES");
    }
}
