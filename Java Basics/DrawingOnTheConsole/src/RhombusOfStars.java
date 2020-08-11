import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int rows = 1; rows <= num; rows++){
            for (int cols = 1; cols <= num - rows; cols++){
                System.out.printf(" ");
            }
            System.out.printf("*");
            for (int cols = 1; cols < rows; cols++){
                System.out.printf(" *");
            }
            System.out.println();
        }
        for (int rows =  1; rows <= num - 1; rows++){
            for (int cols = 1; cols <= rows; cols++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i = 1; i <= num - rows - 1; i++) {
                System.out.printf(" *");

            }
            System.out.println();
        }
    }
}
