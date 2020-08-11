import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = Double.parseDouble(scan.nextLine());
        int pow = Integer.parseInt(scan.nextLine());
        System.out.println(new DecimalFormat("0.####").format(getPoweredNumber(num, pow)));
    }
    static double getPoweredNumber(double num, int pow) {
       double result = 1;
        for (int i = 0; i < pow; i++) {
            result *= num;
        }
       return result;
    }
}
