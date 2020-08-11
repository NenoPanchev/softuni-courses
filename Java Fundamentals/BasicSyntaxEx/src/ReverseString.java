import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        for (int i = name.length() - 1; i > -1 ; i--) {
            char letter = name.charAt(i);
            System.out.printf("%c", letter);
        }
    }
}
