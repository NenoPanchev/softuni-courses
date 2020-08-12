import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String input = scan.nextLine();

            switch (input) {
                case "2":
                    numbersStack.pop();
                    break;

                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;

                default:
                    String[] tokens = input.split("\\s+");
                    numbersStack.push(Integer.parseInt(tokens[1]));
            }
        }
    }
}
