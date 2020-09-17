import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(nums, 0));
    }

    private static int sum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        int currentNum = numbers[index];
        int sumSoFar = currentNum + sum(numbers, index + 1);
        return sumSoFar;
    }
}
