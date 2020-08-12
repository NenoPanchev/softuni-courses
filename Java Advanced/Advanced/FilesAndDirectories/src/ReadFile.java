import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "input.txt";
        try (FileInputStream fis = new FileInputStream(path);){
            int oneByte = fis.read();
            while (oneByte >= 0) {
                String print = Integer.toBinaryString(oneByte);
                System.out.printf("%s ", print);
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
