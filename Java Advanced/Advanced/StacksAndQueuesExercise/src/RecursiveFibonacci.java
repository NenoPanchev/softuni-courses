import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push((long) 1);
        stack.push((long) 1);
        while (stack.size() < num + 1) {
            long currentNum = stack.pop();
            long previousNum = stack.peek();
            long nextNum = currentNum + previousNum;
            stack.push(currentNum);
            stack.push(nextNum);
        }
        System.out.println(stack.pop());
    }
}

