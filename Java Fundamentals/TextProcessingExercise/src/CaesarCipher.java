import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int key = 3;
        String[] ar = text.split("");
        StringBuilder cipheredText = new StringBuilder();
        cipheredText.append(text);
        for (int i = 0; i < text.length(); i++) {
           cipheredText.setCharAt(i, (char) (cipheredText.charAt(i) + key));
        }
        System.out.println(cipheredText);
    //    System.out.println(cipher(text, key));
    }
    static String cipher(String word, int key) {
        char[] wordCharacters = word.toCharArray();
        for (int i = 0; i < wordCharacters.length; i++) {
            wordCharacters[i] += key;
        }

        return new String(wordCharacters);
    }
}
