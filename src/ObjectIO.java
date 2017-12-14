import java.io.*;

public class ObjectIO<T> {

    private String filename;

    public ObjectIO(String filename) {
        this.filename = filename;
    }

    public void save(T obj) {
        String fileName = filename + ".ser";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(obj);
            oos.close();
        } catch (IOException ignored) {}
    }

    @SuppressWarnings(value="unchecked")
    public T load() {
        T obj = null;
        String fileName = filename + ".ser";
        File file = new File(fileName);
        if (file.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
                obj = ( T ) ois.readObject();
                ois.close();
            } catch (ClassNotFoundException | IOException ignored) {}
        }
        return obj;
    }

}
