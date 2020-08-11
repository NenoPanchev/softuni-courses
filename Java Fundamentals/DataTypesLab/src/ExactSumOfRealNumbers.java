import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 1; i <= num; i++){
            BigDecimal currentNum = new BigDecimal(scan.nextLine());
            sum = sum.add(currentNum);
        }
        System.out.println(sum);
    }
}
