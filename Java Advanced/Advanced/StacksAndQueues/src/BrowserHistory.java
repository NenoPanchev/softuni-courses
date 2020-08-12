import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1)
                    System.out.println("no previous URLs");
                else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                System.out.println(input);
                stack.push(input);
            }

            input = scan.nextLine();
        }
    }
}
