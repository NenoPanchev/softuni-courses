import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountsCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] chars = text.split("");

        LinkedHashMap<String, Integer> charCount = new LinkedHashMap<>();

        for (String aChar : chars) {
            if (!aChar.equals(" ")) {
                charCount.putIfAbsent(aChar, 0);
                charCount.put(aChar, charCount.get(aChar) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : charCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
