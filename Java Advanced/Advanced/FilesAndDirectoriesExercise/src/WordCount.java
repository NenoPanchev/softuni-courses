import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String path = "words.txt";
        String textPath = "text.txt";
        String output = "src/WordCount.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        String allWords = Files.readAllLines(Path.of(path)).toString().replaceAll("[\\[\\]]", "");
        String[] words = allWords.split("\\s+");
        for (String word : words) {
            wordCount.put(word, 0);
        }
        String[] text = Files.readAllLines(Path.of(textPath)).toString().replaceAll("[\\[\\]]", "").split("\\s+");
        for (String s : text) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                if (entry.getKey().equals(s))
                    entry.setValue(entry.getValue() + 1);
            }
        }
        PrintWriter printWriter = new PrintWriter(output);
        wordCount.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(x -> printWriter.write(String.format("%s - %d%n", x.getKey(), x.getValue())));
        printWriter.close();
    }
}
