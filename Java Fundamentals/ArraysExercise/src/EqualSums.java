import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isEven = false;
        for (int i = 0; i < numbers.length; i++) {
            int before = 0;
            int after = 0;

            for (int j = 0; j < i; j++) {
                before += numbers[j];
            }
            for (int k = i + 1; k < numbers.length; k++) {
                after += numbers[k];
            }
            if (before == after) {
                isEven = true;
                System.out.println(i);
            }
        }
        if (!isEven) System.out.println("no");
    }
}
