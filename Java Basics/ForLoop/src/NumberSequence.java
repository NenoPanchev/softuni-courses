import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < num; i++){
            int n = Integer.parseInt(scan.nextLine());
            if (n > maxNum)
                maxNum = n;

            if (n < minNum)
                minNum = n;
        }
        System.out.printf("Max number: %d%n", maxNum);
        System.out.printf("Min number: %d", minNum);
    }
}