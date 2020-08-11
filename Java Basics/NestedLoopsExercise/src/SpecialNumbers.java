import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 1111; i <= 9999; i++) {
            boolean isSpecial = true;
            for (int j = 0; j < 4; j++) {
                String letter = Integer.toString(i);
                char currentDigit = letter.charAt(j);
                int currentNum = Integer.parseInt("" + currentDigit);
                if (currentNum != 0 && number % currentNum == 0) isSpecial = true;
                else {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) System.out.print(i + " ");
        }
    }
}
