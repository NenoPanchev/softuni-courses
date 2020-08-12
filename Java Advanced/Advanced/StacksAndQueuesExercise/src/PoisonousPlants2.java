import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] days = new int[num];
        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();
        prevPlants.push(0);

        for (int i = 1; i < num; i++) {
            int day = 0;
            while (!prevPlants.isEmpty() && numbers[prevPlants.peek()] >= numbers[i]) {
                day = Math.max(day, days[prevPlants.pop()]);
            }
            if (!prevPlants.isEmpty())
                days[i] = day + 1;
            prevPlants.push(i);
        }
        System.out.println(Arrays.stream(days)
        .max().getAsInt());
    }
}
