import java.util.Scanner;

public class SushiTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String typeOfSushi = scan.nextLine();
        String restaurant = scan.nextLine();
        int meals = Integer.parseInt(scan.nextLine());
        String takeOut = scan.nextLine();

        double price = 0;

        if (restaurant.equals("Sushi Zone")) {
            switch (typeOfSushi) {
                case "sashimi": price = 4.99; break;
                case "maki": price = 5.29; break;
                case "uramaki": price = 5.99; break;
                case "temaki": price = 4.29; break;
            }
        } else if (restaurant.equals("Sushi Time")) {
            switch (typeOfSushi) {
                case "sashimi": price = 5.49; break;
                case "maki": price = 4.69; break;
                case "uramaki": price = 4.49; break;
                case "temaki": price = 5.19; break;
            }
        } else if (restaurant.equals("Sushi Bar")) {
            switch (typeOfSushi) {
                case "sashimi": price = 5.25; break;
                case "maki": price = 5.55; break;
                case "uramaki": price = 6.25; break;
                case "temaki": price = 4.75; break;
            }
        } else if (restaurant.equals("Asian Pub")) {
            switch (typeOfSushi) {
                case "sashimi": price = 4.50; break;
                case "maki": price = 4.80; break;
                case "uramaki": price = 5.50; break;
                case "temaki": price = 5.50; break;
            }
        }

        double totalPrice = price * meals;
        if (takeOut.equals("Y")) totalPrice = price * meals * 1.2;

        if (restaurant.equals("Sushi Zone") || restaurant.equals("Sushi Time") ||
                restaurant.equals("Sushi Bar") || restaurant.equals("Asian Pub")) {
            System.out.printf("Total price: %.0f lv.", Math.ceil(totalPrice));
        } else
            System.out.printf("%s is invalid restaurant!", restaurant);
    }
}
