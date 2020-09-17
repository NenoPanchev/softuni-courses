package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        double dailyPrice = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String season = input[2];
        String typeOfDiscount = input[3];
        PriceCalculator priceCalculator = new PriceCalculator(dailyPrice, days, season, typeOfDiscount);
        System.out.printf("%.2f", priceCalculator.calculate());
    }
}
