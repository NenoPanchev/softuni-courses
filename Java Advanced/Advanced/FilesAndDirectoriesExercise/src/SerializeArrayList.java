import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 4.5, 2.1, 3.3);
        String path = "src/list.ser";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))){
            outputStream.writeObject(list);
            List<Double> newList = (List<Double>) inputStream.readObject();
            for (Double aDouble : newList) {
                System.out.println(aDouble);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
