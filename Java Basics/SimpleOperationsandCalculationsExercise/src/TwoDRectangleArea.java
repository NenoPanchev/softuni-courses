import java.util.Scanner;

public class TwoDRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double a = Math.max(x1, x2) - Math.min(x1, x2);
        double b = Math.max(y1,y2) - Math.min(y1,y2);
        double area = a*b;
        double perimeter = 2*a + 2*b;
        System.out.printf("%.2f", area);
        System.out.println();
        System.out.printf("%.2f", perimeter);
    }
}
