import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceVegs = Double.parseDouble(scan.nextLine());
        double priceFruits = Double.parseDouble(scan.nextLine());
        int vegKG = Integer.parseInt(scan.nextLine());
        int fruKG = Integer.parseInt(scan.nextLine());
        double total = (priceFruits * fruKG + priceVegs *vegKG) / 1.94;
        System.out.println(total);
    }
}
