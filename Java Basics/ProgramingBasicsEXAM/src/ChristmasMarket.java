import java.util.Scanner;

public class ChristmasMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String decoration = scan.nextLine();
        int count = 0;
        int productsBought = 0;
        double moneySpent = 0;
        double lastPrice = 0;

        while (!decoration.equals("Finish")) {
            double price = 0;
            switch (decoration) {
                case "Star": price = 5.69; break;
                case "Angel": price = 8.49; break;
                case "Lights": price = 11.20; break;
                case "Wreath": price = 15.50; break;
                case "Candle": price = 3.59; break;
            }
            count++;
            if (count % 3 == 0) price *= 0.70;
            lastPrice = price;
            if (price > budget) {
                break;
            } else {
                budget -= price;
                productsBought++;
                moneySpent += price;
                decoration = scan.nextLine();
            }
        }
        if (decoration.equals("Finish")) {
            System.out.println("Congratulations! You bought everything!");
            System.out.printf("%d items -> %.2flv spent.", productsBought, moneySpent);
        } else {
            System.out.printf("Not enough money! You need %.2flv more.%n", lastPrice - budget);
            System.out.printf("%d items -> %.2flv spent.", productsBought, moneySpent);
        }
    }
}
