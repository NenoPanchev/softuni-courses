import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int leftSum = 0;
        int rightSum = 0;


        for (int i = 0; i < 2 * num; i++){
            int n = Integer.parseInt(scan.nextLine());
            if (i < num)
                leftSum += n;
            else
                rightSum += n;
        }
        int diff = Math.abs(rightSum - leftSum);

        if (leftSum == rightSum){
            System.out.printf("Yes, sum = %d", leftSum);}
        else {

            System.out.printf("No, diff = %d", diff);
        }
    }
}
