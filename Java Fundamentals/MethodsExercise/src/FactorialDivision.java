import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        System.out.printf("%.2f", getAdividedB(a,b));
    }
    static long getFactorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    static double getAdividedB(int a, int b) {
        return 1.0 * getFactorial(a) / getFactorial(b);
    }
}
