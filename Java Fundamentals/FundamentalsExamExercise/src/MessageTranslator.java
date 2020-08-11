import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");
                System.out.printf("%s:", command);
                for (int j = 0; j < message.length(); j++) {
                    int asciiNumOfChar = message.charAt(j);
                    System.out.printf(" %d", asciiNumOfChar);
                }
                System.out.println();
            } else
                System.out.println("The message is invalid");
        }
    }
}
