import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern digits = Pattern.compile("\\d");
        Matcher dig = digits.matcher(text);
        long coolThreshold = 1;
        while (dig.find()) {
            coolThreshold *= Integer.parseInt(dig.group());
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);

        Pattern pattern = Pattern.compile("([*]{2}|[:]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        List<String> list = new LinkedList<>();
        while (matcher.find()) {
            counter++;
            String emoji = matcher.group("emoji");
            long coolness = 0;
            for (int i = 0; i < emoji.length(); i++) {
                coolness += emoji.charAt(i);
            }
            if (coolness >= coolThreshold) {
                list.add(matcher.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
