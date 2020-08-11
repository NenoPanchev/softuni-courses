import java.util.Arrays;
import java.util.Scanner;

public class MaxSeq2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 0;
        int index = 0;


        for (int i = 0; i < numbers.length; i++) {
            int currentCount = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    currentCount++;
                    if (currentCount > count) {
                        count = currentCount;
                        index = i;
                    }
                } else {
                    break;
                }

            }

        }
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i + index] + " ");
        }

    }
}
