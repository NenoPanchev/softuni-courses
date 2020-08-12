import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyAPicture {
    public static void main(String[] args) {
        String path = "C:\\Users\\Panchev\\Desktop\\gauntlet.jpg";
        String output = "src/copy-picture.jpg";

        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(output)){
            byte[] bytes = Files.readAllBytes(Path.of(path));
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
