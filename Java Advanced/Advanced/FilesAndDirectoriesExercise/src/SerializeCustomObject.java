import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3.0;

        String path ="src/cube.ser";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))){
            objectOutputStream.writeObject(cube);
            Cube newCube = (Cube) inputStream.readObject();
            System.out.println(newCube.color);
            System.out.println(newCube.height);
            System.out.println(newCube.width);
            System.out.println(newCube.depth);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cube implements Serializable {
    String color;
    double width;
    double height;
    double depth;

    Cube(){}


    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}