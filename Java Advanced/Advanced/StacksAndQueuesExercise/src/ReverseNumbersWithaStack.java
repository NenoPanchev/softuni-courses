import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithaStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();
        for (String s : arr) {
            numberStack.push(Integer.parseInt(s));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(numberStack.poll() + " ");
        }
    }
}
