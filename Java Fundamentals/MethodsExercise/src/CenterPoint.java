import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        getClosestPoint(x1, y1, x2, y2);
    }
    static void getClosestPoint(int x1, int y1, int x2, int y2) {
        if ((Math.abs(x1) + Math.abs(y1)) <= (Math.abs(x2) + Math.abs(y2))) {
            System.out.printf("(%d, %d)", x1, y1);
        }
        else System.out.printf("(%d, %d)", x2, y2);
    }
}
