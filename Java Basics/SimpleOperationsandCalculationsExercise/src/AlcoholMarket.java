import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double whiskeyPrice = Double.parseDouble(scan.nextLine());
        double beer = Double.parseDouble(scan.nextLine());
        double wine = Double.parseDouble(scan.nextLine());
        double rakia = Double.parseDouble(scan.nextLine());
        double whiskey = Double.parseDouble(scan.nextLine());
        double rakiaPrice = whiskeyPrice / 2;
        double winePrice = rakiaPrice *0.6;
        double beerPrice = rakiaPrice * 0.2;
        double result = whiskey * whiskeyPrice + rakia * rakiaPrice + beer * beerPrice + wine * winePrice;
        System.out.printf("%.2f", result);
    }
}
