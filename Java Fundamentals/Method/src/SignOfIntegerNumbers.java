import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printSign(Integer.parseInt(scan.nextLine()));
    }
    static void printSign(int number) {
        if (number > 0)
            System.out.printf("The number %d is positive.", number);
        else if (number == 0)
            System.out.printf("The number %d is zero.", number);
        else
            System.out.printf("The number %d is negative.", number);
    }
}
