import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char a = scan.nextLine().charAt(0);
        char b = scan.nextLine().charAt(0);
        printCharactersInRange(a, b);
    }

    static void printCharactersInRange(char a, char b) {
        if (a < b) {
            for (char i = (char) (a + 1); i < b; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (b + 1); i < a; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
