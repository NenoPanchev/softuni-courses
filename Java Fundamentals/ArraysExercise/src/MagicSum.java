import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputNumbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < inputNumbers.length - 1; i++) {
            for (int j = i + 1; j < inputNumbers.length; j++) {
                if (inputNumbers[i] + inputNumbers[j] == target) {
                    System.out.printf("%d %d%n", inputNumbers[i], inputNumbers[j]);
                }
            }
        }
    }
}
