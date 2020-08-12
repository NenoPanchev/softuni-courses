import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String output = "LineNumbers.txt";
        PrintWriter printWriter = new PrintWriter(output);
        String[] lines = Files.readAllLines(Path.of("inputLineNumbers.txt")).toArray(new String[0]);
        for (int i = 0; i < lines.length; i++) {
            printWriter.printf("%d. %s%n", i + 1, lines[i]);
        }
        printWriter.close();
    }
}
