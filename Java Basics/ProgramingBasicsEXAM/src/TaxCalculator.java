import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int power = Integer.parseInt(scan.nextLine());
        String town = scan.nextLine();
        String ecoStandard = scan.nextLine();

        double price = 0;

        if (power <= 37) {
            switch (town) {
                case "Sofia": price = 1.43; break;
                case "Vidin": price = 1.34; break;
                case "Varna": price = 1.37; break;
            }
        } else if (power <= 55) {
            switch (town) {
                case "Sofia": price = 1.50; break;
                case "Vidin": price = 1.40; break;
                case "Varna": price = 1.40; break;
            }
        } else {
            switch (town) {
                case "Sofia": price = 2.68; break;
                case "Vidin": price = 2.54; break;
                case "Varna": price = 2.57; break;
            }
        }
        double discount = 1;
        if (ecoStandard.equals("Euro 4")) discount = 0.85;
        else if (ecoStandard.equals("Euro 5")) discount = 0.83;
        else if (ecoStandard.equals("Euro 6")) discount = 0.80;
        double total = power * price * discount;

        System.out.printf("%.2f lv", total);
    }
}
