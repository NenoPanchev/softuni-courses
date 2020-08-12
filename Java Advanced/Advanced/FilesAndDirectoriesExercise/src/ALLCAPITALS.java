import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ALLCAPITALS {
    public static void main(String[] args) {
        String path = "input.txt";
        String output = "AllCapitals.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter printWriter = new PrintWriter(output)){
            String line = br.readLine();
            while (line != null) {
                printWriter.println(line.toUpperCase());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
