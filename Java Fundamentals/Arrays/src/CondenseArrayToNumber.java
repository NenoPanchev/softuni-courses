import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        while (nums.length > 1 ) {
            int[] condensed = new int[nums.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = nums[i] + nums[i + 1];
                nums[i] = condensed[i];

            }
        nums = condensed;
        }
        System.out.println(nums[0]);
    }
}
