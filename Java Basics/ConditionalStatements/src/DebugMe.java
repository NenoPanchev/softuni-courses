import java.util.Scanner;

public class DebugMe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int nightCnt = Integer.parseInt(scan.nextLine());
        double nightPrice = Double.parseDouble(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());

        if (nightCnt > 7) {
            nightPrice = nightPrice * 0.95;
        }

        double totalNightPrice = nightCnt * nightPrice;

        double additionalCosts = budget * (percent / 100.00);
        double totalPrice = totalNightPrice + additionalCosts;

        if (totalPrice > budget) {
            double moneyNeed = totalPrice - budget;
            System.out.printf("%.2f leva needed.", moneyNeed);
        } else {
            double moneyLeft = budget - totalPrice;
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", moneyLeft);
        }
    }
}
