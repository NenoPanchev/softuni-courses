import java.util.Scanner;

public class EqualSumsLeftRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            int leftSum = 0;
            int rightSum = 0;
            int mid = 0;
            String currentNumber = "" + i;

            for (int j = 0; j < currentNumber.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNumber.charAt(j));
                if (j == 0 || j == 1) leftSum += currentDigit;
                if (j == 2) mid += currentDigit;
                if (j == 3 || j == 4) rightSum += currentDigit;
            }
            if (leftSum < rightSum) leftSum += mid;
            if (rightSum < leftSum) rightSum += mid;


            if (leftSum == rightSum) {
                System.out.print(i + " ");
            }


        }
    }
}

