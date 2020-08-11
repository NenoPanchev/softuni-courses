import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("(?<string>[^\\d\\n]+)(?<num>\\d\\d?)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder finalText = new StringBuilder();
        while (matcher.find()) {
            String text = matcher.group("string");
            text = text.toUpperCase();
            int num = Integer.parseInt(matcher.group("num"));
            for (int i = 0; i < num; i++) {
                finalText.append(text);
            }
        }
        System.out.printf("Unique symbols used: %d%n", finalText.chars().distinct().count());
        System.out.println(finalText);
    }
}
