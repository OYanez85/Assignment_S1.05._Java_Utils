package Exercise_5;

import java.io.Serializable;

public class MyObject implements Serializable {
    private static final long serialVersionUID = 1L; // Optional, for consistency across serialization
    private String name;
    private int id;

    public MyObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MyObject{name='" + name + "', id=" + id + "}";
    }
}
