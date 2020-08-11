import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String morseText = scan.nextLine();
        char[] english = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|"};

        Map<String, Character> morseCode = new HashMap<>();
        for (int i = 0; i < english.length; i++) {
            morseCode.put(morse[i], english[i]);
        }
        String[] morseLetters = morseText.split("\\s+");
        StringBuilder text = new StringBuilder();
        for (String letter : morseLetters) {
            text.append(morseCode.get(letter));
        }
        System.out.println(text);
    }
}
