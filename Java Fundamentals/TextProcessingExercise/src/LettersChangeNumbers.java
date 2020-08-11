import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] sequences = input.split("\\s+");
        double totalSum = 0.0;

        for (String pair : sequences) {
            char firstChar = pair.charAt(0);
            char lastChar = pair.charAt(pair.length() - 1);
            double number = Double.parseDouble(pair.substring(1, pair.length() - 1));

            if (Character.isUpperCase(firstChar)) {
                int letterPosition = firstChar - 'A' + 1;
                totalSum += number / letterPosition;
            } else {
                int letterPosition = firstChar - 'a' + 1;
                totalSum += number * letterPosition;
            }
            if (Character.isUpperCase(lastChar)) {
                int letterPosition = lastChar - 'A' + 1;
                totalSum -= letterPosition;
            } else {
                int letterPosition = lastChar - 'a' + 1;
                totalSum += letterPosition;
            }
        }
        System.out.printf("%.2f%n", totalSum);
    }
}
