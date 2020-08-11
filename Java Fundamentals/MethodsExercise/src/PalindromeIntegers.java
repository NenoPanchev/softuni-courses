import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scan.nextLine();
        }
    }
    static boolean isPalindrome(String input) {
        String secondWord = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            secondWord += input.charAt(i);
        }
        if (input.equals(secondWord))
            return true;
        return false;
    }
}
