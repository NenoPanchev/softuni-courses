import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder afterExplosion = new StringBuilder();

        int power = 0;
        int skip = 0;

        for (int i = 0; i < text.length(); i++) {
            skip = 0;
            if (text.charAt(i) != '>') {
                afterExplosion.append(text.charAt(i));
            } else {
                afterExplosion.append(text.charAt(i));
                power += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
                int length = power;
                if (length >= text.length() - i) length = text.length() - i - 1;
                for (int j = i + 1; j < i + 1 + length; j++) {
                    if (text.charAt(j) != '>') {
                        power--;
                        skip++;
                    } else
                    break;
                }
                i += skip;
                if (i >= text.length()) break;
            }
        }
        System.out.println(afterExplosion);
    }
}
