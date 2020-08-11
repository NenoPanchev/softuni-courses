import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split( " ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        for (int j = 0; j < numbers.length; j++) {
            boolean isGreater = true;
            for (int k = j + 1; k < numbers.length; k++) {
                if (numbers[j] <= numbers[k]) {
                    isGreater = false;
                    break;
                }
            }
            if (isGreater) {
                System.out.print(numbers[j] + " ");
            }
        }
    }
}
