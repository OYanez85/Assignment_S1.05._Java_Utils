import java.io.*;

class MyObject implements Serializable {
    private String name;
    private int id;

    public MyObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyObject{name='" + name + "', id=" + id + "}";
    }
}

public class SerializeObject {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide a file path and an operation (serialize/deserialize).");
            return;
        }
        String operation = args[1];
        File file = new File(args[0]);

        if (operation.equalsIgnoreCase("serialize")) {
            serializeObject(file);
        } else if (operation.equalsIgnoreCase("deserialize")) {
            deserializeObject(file);
        } else {
            System.out.println("Invalid operation. Use 'serialize' or 'deserialize'.");
        }
    }

    public static void serializeObject(File file) {
        MyObject obj = new MyObject("Test Object", 1);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
            System.out.println("Object serialized to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeObject(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            MyObject obj = (MyObject) ois.readObject();
            System.out.println("Object deserialized: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
