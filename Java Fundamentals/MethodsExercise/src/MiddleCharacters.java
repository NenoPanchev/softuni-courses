import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        System.out.println(printMiddleOfString(string));
    }
    static String printMiddleOfString(String string) {

        if (string.length() % 2 == 0) {
        char middle = string.charAt(string.length() / 2 - 1);
        char midPlusOne = string.charAt(string.length() / 2);
        return "" + middle + midPlusOne;
        } else {
            char mid = string.charAt(string.length() / 2);
            return mid + "";
        }

    }
}
