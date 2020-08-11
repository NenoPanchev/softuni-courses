import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder cropped = new StringBuilder();
        cropped.append(text.charAt(0));
        char ch = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != ch) {
                ch = text.charAt(i);
                cropped.append(ch);
            }
        }
        System.out.println(cropped);
    }
}
