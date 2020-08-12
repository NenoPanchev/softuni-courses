import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "inputOne.txt";
        String pathTwo = "inputTwo.txt";
        String output = "src/MergeTwoFiles.txt";
        List<String> readOne = Files.readAllLines(Path.of(pathOne));
        List<String> readTwo = Files.readAllLines(Path.of(pathTwo));
        List<String> three = new ArrayList<>();
        three.addAll(readOne);
        three.addAll(readTwo);
        Files.write(Paths.get(output), three);

//        try (PrintWriter printWriter = new PrintWriter(output);
//             BufferedWriter writer = new BufferedWriter(printWriter)){
//            for (String s : readOne) {
//                writer.write(String.format("%s%n", s));
//            }
//            for (String s : readTwo) {
//                writer.write(String.format("%s%n", s));
//            }
//        }
    }
}
