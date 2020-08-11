import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tables = Integer.parseInt(scan.nextLine());
        double tableLength = Double.parseDouble(scan.nextLine());
        double tableWidth = Double.parseDouble(scan.nextLine());
        double rectangles = tables * (tableLength +0.60) * (tableWidth + 0.60);
        double squares = tables * (tableLength / 2) * (tableLength / 2);
        double usd = rectangles * 7 + squares * 9;
        double bgn = usd * 1.85;
        System.out.printf("%.2f USD", usd);
        System.out.println();
        System.out.printf("%.2f BGN", bgn);
    }
}
