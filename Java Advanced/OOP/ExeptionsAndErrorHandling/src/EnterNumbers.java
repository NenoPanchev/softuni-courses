import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        run(scan);
    }

    private static void run(Scanner scan) {
        while (true) {
            try {
                printNumbers(scan);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                run(scan);
            }
        }
    }

    private static void printNumbers(Scanner scan) {
            int start = readAndValidateNumber(scan);
            int end = readAndValidateNumber(scan);
            if (start <= 1 || start >= end || end >= 100) {
                throw new IllegalArgumentException("Those are not valid numbers.\n" +
                        "Please, enter valid numbers in the form of: 1 < start < end < 100");
            }

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int readAndValidateNumber(Scanner scan) {
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("This is not a number!\n" +
                    "Please, enter a real number!");
            readAndValidateNumber(scan);
        }
        return 0;
    }
}
