import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        if (isZero(a, b, c)) System.out.println("zero");
        else if (!isPositive(a, b ,c)) System.out.println("negative");
        else System.out.println("positive");
    }
    static boolean isPositive(int a, int b, int c) {
        if ((a > 0 && b > 0 && c > 0) || (a < 0 && b < 0 && c > 0) || (a < 0 && b > 0 && c < 0) ||
                (a > 0 && b < 0 && c < 0)) return true;
        return false;
    }
    static boolean isZero(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) return true;
        return false;
    }
}
