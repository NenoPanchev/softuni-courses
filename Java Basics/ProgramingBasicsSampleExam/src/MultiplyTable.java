import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int firstDigit = num % 10;
        int secondDigit = (num / 10) % 10;
        int thirdDigit = num / 100 % 10;

        for (int i = 1; i <= firstDigit; i++) {
            for (int j = 1; j <= secondDigit; j++) {
                for (int k = 1; k <= thirdDigit; k++) {
                    System.out.printf("%d * %d * %d = %d;%n", i, j, k, i * j * k);

                }
            }
        }
    }
}
