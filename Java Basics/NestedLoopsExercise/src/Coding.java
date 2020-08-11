import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();

        for (int cols = number.length() - 1; cols > -1; cols--) {
            char currentDigit = number.charAt(cols);
            int currentNum = Integer.parseInt("" + currentDigit);

            if (currentNum == 0) {
                System.out.println("ZERO");
            } else {

                for (int i = 0; i < currentNum; i++) {
                    System.out.print((char) (currentNum + 33));
                }
                System.out.println();
            }
        }
    }
}
