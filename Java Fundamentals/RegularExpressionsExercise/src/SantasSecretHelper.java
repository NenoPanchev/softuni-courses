import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            input = cipher(input, key);
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]+!(?<behavior>[GN])!");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && matcher.group("behavior").equals("G")) {
                System.out.println(matcher.group("name"));
            }

            input = scan.nextLine();
        }

    }
    static String cipher(String word, int key) {
        char[] wordCharacters = word.toCharArray();
        for (int i = 0; i < wordCharacters.length; i++) {
            wordCharacters[i] -= key;
        }

        return new String(wordCharacters);
    }
}
