import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int one = Integer.parseInt(scan.nextLine());
        int two = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();

        double result = 0.0;
        String oddOrEven = "";

        switch (operator){
            case "+": result = one + two; break;
            case "-": result = one - two; break;
            case "*": result = one * two; break;

        }
        if (operator.equals("/") && two !=0){
            System.out.printf("%d %s %d = %.2f", one, operator, two, (one * 1.0 / two * 1.0));
        } else if (operator.equals("/") && two == 0)
            System.out.printf("Cannot divide %d by zero", one);
        if (operator.equals("+") || operator.equals("-") || operator.equals("*")){
            if (result % 2 == 0)
                oddOrEven = "even";
            else oddOrEven = "odd";
            System.out.printf("%d %s %d = %.0f - %s", one, operator, two, result, oddOrEven);
        }

        if (operator.equals("%") && two !=0){
            System.out.printf("%d %s %d = %d", one, operator, two, one % two);
        } else if (operator.equals("%") && two == 0) {
            System.out.printf("Cannot divide %d by zero", one);
        }
    }
}
