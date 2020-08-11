import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printSquare(num);
    }
    static void printSquare(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}
