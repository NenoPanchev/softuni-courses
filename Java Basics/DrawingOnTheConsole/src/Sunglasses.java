import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        //header
        for (int i = 0; i < num * 2; i++) {
            System.out.printf("*");
        }
        for (int j = 0; j < num; j++) {
            System.out.printf(" ");
        }
        for (int k = 0; k < num * 2; k++) {
            System.out.printf("*");
        }
        System.out.println();

        //middle
        for (int rows = 0; rows < num - 2; rows++) {
            System.out.printf("*");
            for (int slash = 0; slash < num * 2 - 2; slash++) {
                System.out.printf("/");
            }
            System.out.printf("*");

            if (rows == ((num - 1) / 2 - 1)) {
                for (int i = 1; i <= num; i++) {
                    System.out.printf("|");
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    System.out.printf(" ");
                }
            }
            System.out.printf("*");
            for (int slash = 0; slash < num * 2 - 2; slash++) {
                System.out.printf("/");
            }
            System.out.printf("*");
            System.out.println();
        }


        //footer
        for (int i = 0; i < num * 2; i++) {
            System.out.printf("*");
        }
        for (int j = 0; j < num; j++) {
            System.out.printf(" ");
        }
        for (int k = 0; k < num * 2; k++) {
            System.out.printf("*");
        }
    }
}
