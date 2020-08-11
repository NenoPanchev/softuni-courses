import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printTriangle(num);
    }

    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static void printTriangle(int num) {
        for (int line = 1; line <= num; line++) {
            printLine(1, line);
        }
        for (int line = num - 1; line >= 1; line--) {
            printLine(1, line);
        }
    }
}
