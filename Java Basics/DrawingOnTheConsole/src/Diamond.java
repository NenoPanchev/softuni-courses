import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int stars = 1;
        if (num % 2 == 0) stars++;
        int leftRight = (num - 1) / 2;
        int mid = num - 2 * leftRight - 2;


        for (int rows = 0; rows < (num + 1) / 2; rows++) {
            for (int lines = 0; lines < (num - 1) / 2; lines++) {
                System.out.printf("-");
            }
            System.out.printf("*");

            if (mid >= 0){
                for (int inside = 0; inside < mid; inside++) {
                    System.out.printf("-");
                }
                System.out.printf("*");
            }
            for (int lines = 0; lines < (num - 1) / 2; lines++) {
                System.out.printf("-");
            }
            System.out.println();
        }

    }
}
