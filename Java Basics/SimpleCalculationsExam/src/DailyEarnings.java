import java.util.Scanner;

public class DailyEarnings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double daily = Double.parseDouble(scan.nextLine());
        double dollar = Double.parseDouble(scan.nextLine());
        double monthly = days * daily;
        double total = monthly * 14.5 * 0.75 / 365;
        double leva = total * dollar;
        System.out.printf("%.2f", leva);
    }
}
