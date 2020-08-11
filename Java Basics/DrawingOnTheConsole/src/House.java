import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int stars = 1;
        if (num % 2 == 0) stars++;

        // roof
        for (int rows = 1; rows <= (num + 1) / 2; rows++) {
            for (int line = 0; line < (num - stars) / 2; line++) {
                System.out.printf("-");
            }
            for (int star = 1; star <= stars; star++) {
                System.out.printf("*");
            }
            for (int line = 0; line < (num - stars) / 2; line++) {
                System.out.printf("-");
            }
            stars+=2;
            System.out.println();
        }

        // footer
        for (int rows = 0; rows < num / 2; rows++) {
            System.out.printf("|");
            for (int cols = 0; cols < num - 2; cols++) {
                System.out.printf("*");
            }
            System.out.printf("|");
            System.out.println();
        }

    }
}
