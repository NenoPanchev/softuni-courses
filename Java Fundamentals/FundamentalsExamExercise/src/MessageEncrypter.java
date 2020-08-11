import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("([*@])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<one>[A-Za-z])\\]\\|\\[(?<two>[A-Za-z])\\]\\|\\[(?<three>[A-Za-z])\\]\\|$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int one = matcher.group("one").charAt(0);
                int two = matcher.group("two").charAt(0);
                int three = matcher.group("three").charAt(0);
                System.out.printf("%s: %d %d %d%n", tag, one, two, three);
            } else
                System.out.println("Valid message not found!");
        }
    }
}
