import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().split(" ");
        String swap = "";
        for (int i = 0; i < elements.length / 2; i++) {
            swap = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = swap;
        }
        System.out.printf(String.join(" ", elements));
    }
}
