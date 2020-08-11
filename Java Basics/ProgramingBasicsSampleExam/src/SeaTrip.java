import java.util.Scanner;

public class SeaTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double foodMoney = Double.parseDouble(scan.nextLine());
        double souvenirsMoney = Double.parseDouble(scan.nextLine());
        double hotelMoney = Double.parseDouble(scan.nextLine());

        double travelingMoney = 4.2 * 7 * 1.85;
        double dayOne = hotelMoney * .9;
        double dayTwo = hotelMoney * .85;
        double dayThree = hotelMoney * .8;

        double totalMoney = 3 * foodMoney + 3 * souvenirsMoney + travelingMoney + dayOne + dayTwo + dayThree;

        System.out.printf("Money needed: %.2f", totalMoney);
    }
}
