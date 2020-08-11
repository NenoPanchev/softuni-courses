import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char a = scan.nextLine().charAt(0);
        char b = scan.nextLine().charAt(0);
        String text = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar > Math.min(a, b) && currentChar < Math.max(a, b)) {
                sum += currentChar;
            }
        }
        System.out.println(sum);
    }
}
