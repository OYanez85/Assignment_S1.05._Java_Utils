package Exercise_5;

import java.io.*;

public class SerializeObject {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Please provide a file path and an operation (serialize/deserialize).");
            return;
        }

        String operation = args[1];
        File file = new File(args[0]);

        if (operation.equalsIgnoreCase("serialize")) {
            serializeObject(file);
        } else if (operation.equalsIgnoreCase("deserialize")) {
            deserializeObject(file);
        } else {
            System.err.println("Invalid operation. Use 'serialize' or 'deserialize'.");
        }
    }

    public static void serializeObject(File file) {
        MyObject obj = new MyObject("Test Object", 1);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
            System.out.println("Object serialized to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error: Failed to serialize object - " + e.getMessage());
        }
    }

    public static void deserializeObject(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            MyObject obj = (MyObject) ois.readObject();
            System.out.println("Object deserialized: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: Failed to deserialize object - " + e.getMessage());
        }
    }
}
