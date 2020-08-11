import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int row = 0; row <= num; row++){
            for (int space = 1; space <= num - row; space++){
                System.out.printf(" ");
            }
            for (int stars = 1; stars <= row; stars++) {
                System.out.printf("*");
            }
            System.out.printf(" | ");
            for (int stars = 1; stars <= row; stars++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
