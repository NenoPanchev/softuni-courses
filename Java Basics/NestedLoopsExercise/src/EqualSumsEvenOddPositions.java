import java.util.Scanner;

public class EqualSumsEvenOddPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());


        for (int i = firstNum; i <= secondNum; i++){
            int oddSum = 0;
            int evenSum = 0;
            String currentNum = "" + i;
            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
                if (j % 2 == 0){
                    evenSum+= currentDigit;
                } else oddSum += currentDigit;
            }
            if (oddSum == evenSum)
                System.out.print(i + " ");
        }
    }
}
