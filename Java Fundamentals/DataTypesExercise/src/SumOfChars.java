import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 1; i <= num; i++){
            char letter = scan.nextLine().charAt(0);
            sum += letter;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
