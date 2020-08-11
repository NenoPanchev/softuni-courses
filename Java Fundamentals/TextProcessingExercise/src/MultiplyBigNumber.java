import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        StringBuilder reversedText = new StringBuilder();
        int leftOver = 0;
        if (num != 0) {
            for (int i = 0; i < bigNumber.length(); i++) {
                char ch = bigNumber.charAt(i);
                if (ch != '0') {
                    bigNumber = bigNumber.substring(i);
                    break;
                }
            }

            for (int i = bigNumber.length() - 1; i >= 0; i--) {
                int currentNumber = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
                int result = currentNumber * num;
                int lastDigit = (result + leftOver) % 10;
                leftOver = (result + leftOver) / 10;
                reversedText.append(lastDigit);
                if (i == 0 && leftOver != 0)
                    reversedText.append(leftOver);
            }
            for (int i = reversedText.length() - 1; i >= 0; i--) {
                if (reversedText.charAt(i) == '0') {
                    int position = Integer.parseInt(String.valueOf(reversedText.charAt(i)));
                    reversedText.replace(position, position, "");
                }
            }
            System.out.println(reversedText.reverse());
        } else
            System.out.println(0);
    }
}