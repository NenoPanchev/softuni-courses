import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        String znak = scan.nextLine();
        int b = Integer.parseInt(scan.nextLine());
        double result = getResult(a, znak, b);
        System.out.println(new DecimalFormat("0.##").format(getResult(a, znak, b)));

    }
    static double getResult(int one, String operator, int two) {
        double result = 0;
        switch (operator) {
            case "+": result = one + two; break;
            case "-": result = one - two; break;
            case "*": result = one * two; break;
            case "/": result = 1.0 * one / two; break;
        }
        return result;
    }
}
