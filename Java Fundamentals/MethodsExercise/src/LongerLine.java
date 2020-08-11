import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x3 = Double.parseDouble(scan.nextLine());
        double y3 = Double.parseDouble(scan.nextLine());
        double x4 = Double.parseDouble(scan.nextLine());
        double y4 = Double.parseDouble(scan.nextLine());

        getLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    static void getLongerLine(double x1, double y1, double x2, double y2, double x3,
                              double y3, double x4, double y4) {
        if ((Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2))) >=
                (Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4)*(y3 - y4)))) {
            printClosestPoint(x1, y1, x2, y2);
        }
        else printClosestPoint(x3, y3, x4, y4);
    }

    static void printClosestPoint(double x1, double y1, double x2, double y2) {
        if (Math.sqrt(x1*x1 + y1*y1) <= Math.sqrt(x2 * x2 + y2 * y2)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
        }
        else System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
    }
}
