import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int previousNum = numbers[0];
        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();
        for (int i = 1; i < num; i++) {
            queueNumbers.offer(numbers[i]);
        }
        boolean condition = false;
        int days = 0;

        while (!condition) {
            int sizeOfQueue = queueNumbers.size();
            for (int i = 0; i < sizeOfQueue; i++) {
                int currentNum = queueNumbers.poll();
                if (currentNum <= previousNum) {
                    queueNumbers.offer(currentNum);
                }
                previousNum = currentNum;
            }
            if (queueNumbers.size() == sizeOfQueue) {
                condition = true;
                break;
            }
            previousNum = numbers[0];
            days++;
        }
        System.out.println(days);
    }
}
