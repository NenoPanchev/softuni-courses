import java.util.Scanner;

public class MtoKm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        double metres = num / 1000.0;
        System.out.printf("%.2f", metres);
    }
}
