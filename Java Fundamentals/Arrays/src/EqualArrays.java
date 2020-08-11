import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] secondArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        boolean noBreak = true;
        for (int i = 0; i < firstArr.length; i++){
            sum += firstArr[i];
            if (firstArr[i] != secondArr[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                noBreak = false;
                break;
            }
        }
        if (noBreak)
            System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
