import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            queue.offer(number);
        }
        numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            stack.push(number);
        }

        int lootValue = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int first = queue.peek();
            int second = stack.peek();
            int sum = first + second;
            if (sum % 2 == 0) {
                lootValue += queue.poll() + stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }
        if (queue.isEmpty()) {
            System.out.print("First ");
        } else if (stack.isEmpty()) {
            System.out.print("Second ");
        }
        System.out.println("lootbox is empty");
        if (lootValue >= 100) {
            System.out.print("Your loot was epic! Value: ");
        } else {
            System.out.print("Your loot was poor... Value: ");
        }
        System.out.println(lootValue);
    }
}
