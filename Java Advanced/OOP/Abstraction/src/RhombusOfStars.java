import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printTopHalf(num);
        printBottomHalf(num);
    }

    public static void printRow(int emptySpaces, int stars) {
        for (int i = 0; i < emptySpaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void printTopHalf(int num) {
        for (int rows = 1; rows <= num; rows++) {
            printRow(num - rows, rows);
        }
    }

    public static void printBottomHalf(int num) {
        for (int rows = num - 1; rows >= 1; rows--) {
            printRow(num - rows, rows);
        }
    }
}
