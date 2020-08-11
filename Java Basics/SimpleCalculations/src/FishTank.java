import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());
        int full = a * b * h;
        double litres = full * 0.001;
        double percent2 = percent * 0.01;
        double result = litres * (1-percent2);
        System.out.printf("%.3f", result);
    }
}
