import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "input.txt";
        String output = "src/WriteToFile.txt";
        try (FileInputStream inputStream = new FileInputStream(path);
             FileOutputStream outputStream = new FileOutputStream(output)){
            List<Character> punctuation = List.of(',', '.', '!', '?');
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    outputStream.write(oneByte);
                }

                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
