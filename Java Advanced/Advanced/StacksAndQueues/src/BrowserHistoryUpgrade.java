import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1)
                    System.out.println("no previous URLs");
                else {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                }
            } else if ("forward".equals(input)) {
                if (queue.isEmpty())
                    System.out.println("no next URLs");
                else {
                    System.out.println(queue.peek());
                    stack.push(queue.pop());
                }
            } else {
                System.out.println(input);
                stack.push(input);
                queue.clear();
            }

            input = scan.nextLine();
        }
    }
}
