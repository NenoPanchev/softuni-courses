import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int numMin = Integer.MAX_VALUE;
        int numMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            int num1 = Integer.parseInt(scan.nextLine());
            int num2 = Integer.parseInt(scan.nextLine());
            if (num1 + num2 > numMax) numMax = num1 + num2;
            if (num1 + num2 < numMin) numMin = num1 + num2;
        }
        if (numMin == numMax)
            System.out.printf("Yes, value=%d", numMax);
        else
            System.out.printf("No, maxdiff=%d", Math.abs(numMax - numMin));
    }
}
