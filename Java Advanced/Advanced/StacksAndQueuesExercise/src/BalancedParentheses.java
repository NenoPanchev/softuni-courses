import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String parentheses = scan.nextLine();
        char[] arr = parentheses.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : arr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.size() > 0 && ((c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[') ||
                        (c == ')' && stack.peek() == '('))) {
                    stack.pop();
                } else
                    stack.push(c);
            }
        }
        System.out.println(stack.isEmpty() ? "YES" : "NO");

    }
}
