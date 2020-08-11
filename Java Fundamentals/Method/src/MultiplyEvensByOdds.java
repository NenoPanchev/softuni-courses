import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int sum = getMultipliedEvensByOdds(num);
        System.out.println(sum);
    }
    static int getEvenSum(int num) {
        int evenSum = 0;
        int currentNum = num;
        while (currentNum != 0) {
            if ((currentNum % 10) % 2 == 0)
                evenSum += currentNum % 10;
                currentNum /= 10;
        }
        return evenSum;
    }
    static int getOddSum(int num) {
        int oddSum = 0;
        int currentNum = num;
        while (currentNum != 0) {
            if ((currentNum % 10) % 2 != 0)
                oddSum += currentNum % 10;
            currentNum /= 10;
        }
        return oddSum;
    }
    static int getMultipliedEvensByOdds(int result) {
        int evenSum = getEvenSum(result);
        int oddSum = getOddSum(result);
        int finalResult = evenSum * oddSum;
        return finalResult;
    }
}
