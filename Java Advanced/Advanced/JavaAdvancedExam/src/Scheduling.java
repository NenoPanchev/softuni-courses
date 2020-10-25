import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scan.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();
            if (currentTask == taskToKill) {
                break;
            }
            if (currentThread >= currentTask) {
                tasks.pop();
            }
            threads.poll();
        }
        System.out.printf("Thread with value %d killed task %d%n",
                threads.peek(),
                taskToKill);
        System.out.println(threads.toString().replaceAll("[\\[\\],]", ""));
    }
}
