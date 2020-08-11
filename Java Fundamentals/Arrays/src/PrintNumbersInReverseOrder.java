import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int[] numbers = new int[num];
        for (int i = 0; i < numbers.length; i++){
            int currentNum = Integer.parseInt(scan.nextLine());
            numbers[i] = currentNum;
        }
        int swap = 0;
        for (int j = 0; j < numbers.length / 2; j++) {
            swap = numbers[j];
            numbers[j] = numbers[numbers.length - 1 - j];
            numbers[numbers.length - 1 - j] = swap;
        }
        for (int i = 0; i < numbers.length; i++){
            System.out.printf("%d ", numbers[i]);
        }
    }
}
