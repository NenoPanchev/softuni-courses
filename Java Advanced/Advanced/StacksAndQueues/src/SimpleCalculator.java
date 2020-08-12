import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> calculator = new ArrayDeque<>(Arrays.asList(input));

        while (calculator.size() > 1) {
            int first = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int second = Integer.parseInt(calculator.pop());

            switch (operator) {
                case "+":
                    calculator.push(String.valueOf(first + second));
                    break;

                case "-":
                    calculator.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(calculator.pop());
    }
}
