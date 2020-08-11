import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!"end".equals(input)) {
            Pattern pattern = Pattern.compile("^([A-Z][a-z ']+):([A-Z ]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String artist = matcher.group(1);
                String song = matcher.group(2);
                int key = artist.length();
                String encrypted = encrypt(input, key);
                System.out.printf("Successful encryption: %s%n", encrypted);
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }

    private static String encrypt(String input, int key) {
        char[] letters = input.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ':') {
                letters[i] = '@';
            } else  {
                if (letters[i] != '\'' && letters[i] != ' ')
                letters[i] = getNewLetter(letters[i], key);
            }
        }
        input = "";
        for (char letter : letters) {
            input += letter;
        }
        return input;
    }

    private static char getNewLetter(char letter, int key) {
        letter += key;
        if ((Character.isLowerCase(letter - key) && letter > (int) 'z') ||
                (Character.isUpperCase(letter - key) && letter > (int) 'Z')) {
            letter -= 26;
        }
        return letter;
    }
}
