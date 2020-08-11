import java.util.Scanner;
import java.math.BigInteger;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printRestFibonacciNumbers(num);
    }
    static void printRestFibonacciNumbers(int num) {
        if (num <= 0) System.out.println(1);
        else if (num == 1) System.out.println("1 1");
        else {
            System.out.print("1 1 2 ");
            BigInteger[] fibonacci = new BigInteger[num];
            fibonacci[0] = 1;
            fibonacci[1] = 1;
            fibonacci[2] = 2;
            for (int i = 3; i < fibonacci.length; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3];
                System.out.printf("%d ", fibonacci[i]);
            }
        }
    }
}
