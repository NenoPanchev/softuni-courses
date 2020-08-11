import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(",\\s+");
        String text = scan.nextLine();

        for (String word : bannedWords) {
            String replacement = repeat("*", word.length());
            while (text.contains(word)) {
               text = text.replace(word, replacement);
            }
        }
        System.out.println(text);
    }
    static String repeat(String s, int length) {
        String[] copies = new String[length];
        for (int i = 0; i < length; i++) {
            copies[i] = s;
        }
        return String.join("", copies);
    }
}
