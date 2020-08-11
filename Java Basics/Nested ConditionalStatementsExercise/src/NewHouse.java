import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowers = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double price = 0;
        double discount = 1;
        switch (flowers){
            case "Roses": price = 5; break;
            case "Dahlias": price = 3.8; break;
            case "Tulips": price = 2.8; break;
            case "Narcissus": price = 3; break;
            case "Gladiolus": price = 2.5; break;
        }
        if (flowers.equals("Roses") && count > 80)
            discount = 0.9;
        else if (flowers.equals("Dahlias") && count > 90)
            discount = 0.85;
        else if (flowers.equals("Tulips") && count > 80)
            discount = .85;
        else if (flowers.equals("Narcissus") && count < 120)
            discount = 1.15;
        else if (flowers.equals("Gladiolus") && count < 80)
            discount = 1.2;

        double total = count * price * discount;
        if (total <= budget)
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, flowers, (budget - total));
        else System.out.printf("Not enough money, you need %.2f leva more.", (total - budget));
    }
}
