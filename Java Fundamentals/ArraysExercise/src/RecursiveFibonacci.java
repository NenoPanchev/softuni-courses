import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        long[] fibonacci = new long[num];
        if (num == 1) System.out.println(1);
        else {
            fibonacci[0] = 1;
            fibonacci[1] = 1;
            for (int i = 2; i < fibonacci.length; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }

            System.out.println(fibonacci[num - 1]);
        }
    }
}
