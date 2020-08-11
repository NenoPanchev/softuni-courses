import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(scan.nextLine());
            if (num < 200) counter1 += 1;
            else if (num < 400 ) counter2 += 1;
            else if (num < 600 ) counter3 += 1;
            else if (num < 800 ) counter4 += 1;
            else if (num >= 800 ) counter5 += 1;
        }
        double p1 = 1.0 * counter1 / n * 100;
        double p2 = 1.0 * counter2 / n * 100;
        double p3 = 1.0 * counter3 / n * 100;
        double p4 = 1.0 * counter4 / n * 100;
        double p5 = 1.0 * counter5 / n * 100;

        System.out.printf("%.2f%%", p1);
        System.out.println();
        System.out.printf("%.2f%%", p2);
        System.out.println();
        System.out.printf("%.2f%%", p3);
        System.out.println();
        System.out.printf("%.2f%%", p4);
        System.out.println();
        System.out.printf("%.2f%%", p5);
    }
}
