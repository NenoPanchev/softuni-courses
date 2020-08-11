import java.util.Scanner;

public class ChristmasSweets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceBaklava = Double.parseDouble(scan.nextLine());
        double priceMuffin = Double.parseDouble(scan.nextLine());
        double kilosShtolen = Double.parseDouble(scan.nextLine());
        double kilosBonbons = Double.parseDouble(scan.nextLine());
        int kilosBisquits = Integer.parseInt(scan.nextLine());

        double priceShtolen = priceBaklava * 1.6;
        double priceBonbons = priceMuffin * 1.8;
        double priceBisquits = 7.5;

        double sum = kilosShtolen * priceShtolen + kilosBonbons * priceBonbons + kilosBisquits * priceBisquits;
        System.out.printf("%.2f", sum);
    }
}
