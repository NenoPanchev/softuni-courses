import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays
        .stream(scan.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

        int[] output = new int[input.length];
        int counter = 0;
        int currentNumber = input[0];
        int currentNumberPosition = 0;
        int newArrayPosition = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > currentNumber) {
                currentNumber = input[i];
                output[newArrayPosition] = currentNumber;
                newArrayPosition++;
            }
            counter++;
        }
        for (int i : output) {
            System.out.printf("%d ", i);
        }
    }
}
