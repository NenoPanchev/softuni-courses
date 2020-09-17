import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        System.out.println(recursiveFactorial(num));
    }
    private static int recursiveFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        int currentNum = recursiveFactorial(num - 1);
        int productSofar = currentNum * num;
        return productSofar;
    }
}
