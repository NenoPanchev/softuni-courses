import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double oddSum = 0;
        double oddMin = Double.MAX_VALUE;
        double oddMax = -1000000000;
        double evenSum = 0;
        double evenMin = Double.MAX_VALUE;
        double evenMax = -1000000000;

        for (int i = 1; i <= n; i++){
           double num = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0){
                if (num > evenMax) evenMax = num;
                if (num < evenMin) evenMin = num;
                evenSum += num;
            } else {
                if (num > oddMax) oddMax = num;
                if (num < oddMin) oddMin = num;
                oddSum += num;
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddSum == 0){
            System.out.printf("OddMin=No,%n");
            System.out.printf("OddMax=No,%n");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenSum == 0){
            System.out.printf("EvenMin=No,%n");
            System.out.printf("EvenMax=No%n");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f", evenMax);
        }
    }
}
