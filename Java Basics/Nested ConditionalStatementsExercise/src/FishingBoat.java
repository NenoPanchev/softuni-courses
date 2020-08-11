import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());

        double price = 0;
        double discount = 1;

        switch (season){
            case "Spring": price = 3000; break;
            case "Summer":
            case "Autumn": price = 4200; break;
            case "Winter": price = 2600; break;
        }
        if (count <= 6)
            discount = .9;
        else if (count <=11)
            discount = .85;
        else
            discount = .75;

        if (count % 2 == 0 && !season.equals("Autumn"))
            discount *= .95;

        double total = price * discount;

        if (budget >= total)
            System.out.printf("Yes! You have %.2f leva left.", (budget - total));
        else System.out.printf("Not enough money! You need %.2f leva.", (total - budget));
    }
}
