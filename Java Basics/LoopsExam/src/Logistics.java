import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int van = 0;
        int vanTons= 0;
        int truck = 0;
        int truckTons = 0;
        int train = 0;
        int trainTons = 0;
        int tons = 0;

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(scan.nextLine());
            if (num <= 3) {
                van++;
                vanTons+= num;
            }
            else if (num <= 11) {
                truck++;
                truckTons += num;
            }
            else {
                train++;
                trainTons += num;
            }
            tons += num;
        }
        double avgPrice = (1.0 * vanTons * 200 + truckTons * 175 + trainTons * 120) / tons;
        System.out.printf("%.2f%n", avgPrice);
        System.out.printf("%.2f%%%n", (1.0 * vanTons / tons * 100));
        System.out.printf("%.2f%%%n", (1.0 * truckTons / tons * 100));
        System.out.printf("%.2f%%%n", (1.0 * trainTons / tons * 100));
    }
}
