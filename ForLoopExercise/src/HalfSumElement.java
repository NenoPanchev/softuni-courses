import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(scan.nextLine());
            if (n > maxNum) {
                maxNum = n;
            }
            sum += n;
        }
        if (sum - maxNum == maxNum)
            System.out.printf("Yes%nSum = %d", maxNum);
        else System.out.printf("No%nDiff = %d", (Math.max(maxNum, sum - maxNum) - Math.min(maxNum, sum - maxNum)));
    }
}
