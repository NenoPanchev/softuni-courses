import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());
        if (multiplier > 10) System.out.printf("%d X %d = %d%n", num, multiplier, multiplier * num);
        else {
            for (int i = multiplier; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", num, i, i * num);
            }
        }
    }
}
