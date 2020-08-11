import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int number = Integer.parseInt(num);
        int sum = 0;

        for (int i = 0; i < num.length(); i++){
            int digit = Character.getNumericValue(num.charAt(i));
                    int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            sum += factorial;
        }
        if (sum == number) System.out.println("yes");
        else System.out.println("no");
    }
}
