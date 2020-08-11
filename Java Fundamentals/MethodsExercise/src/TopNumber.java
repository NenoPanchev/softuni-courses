import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= num; i++){
            if (itsDigitsDivideBy8(i) && hasOddDigit(i))
                System.out.println(i);
        }

    }
    static boolean itsDigitsDivideBy8(int num) {
       int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 8 == 0)
            return true;
        return false;
    }
    static boolean hasOddDigit(int num) {
        while (num != 0) {
            if ((num % 10) % 2 != 0)
                return true;
            num /= 10;
        }
        return false;
    }
}
