import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num; i++){
            int number = i;
            int sum = 0;
            while (number != 0){
                int digit = number % 10;
                sum += digit;
                number = number / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            }
            else System.out.printf("%d -> False%n", i);

        }
    }
}
