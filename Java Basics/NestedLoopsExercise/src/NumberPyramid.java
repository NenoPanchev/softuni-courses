import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int counter = 0;

        for (int rows = 1; rows <= num; rows++){

            for (int cols = 1; cols <= rows; cols++){
                counter++;
                System.out.printf("%d ", counter);
                if (counter == num) break;

            }
            System.out.println();
            if (counter == num) break;
        }
    }
}
