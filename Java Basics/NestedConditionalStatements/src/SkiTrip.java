import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = Integer.parseInt(sc.nextLine());
        String room = sc.nextLine();
        String rating = sc.nextLine();

        int nights = days - 1;
        double price = 0.0;

        if (days < 10) {
            switch (room) {
                case "room for one person":
                    price = nights * 18;
                    break;
                case "apartment":
                    price = nights * 25 * 0.7;
                    break;
                case "president apartment":
                    price = nights * 35 * 0.9;
                    break;
            }
        } else if (days <= 15) {
            switch (room) {
                case "room for one person":
                    price = nights * 18;
                    break;
                case "apartment":
                    price = nights * 25 * 0.65;
                    break;
                case "president apartment":
                    price = nights * 35 * 0.85;
                    break;
            }
        } else {
            switch (room) {
                case "room for one person":
                    price = nights * 18;
                    break;
                case "apartment":
                    price = nights * 25 * 0.5;
                    break;
                case "president apartment":
                    price = nights * 35 * 0.8;
                    break;
            }
        }

        switch (rating) {
            case "positive":
                price *= 1.25;
                break;
            case "negative":
                price *= 0.9;
                break;
        }
        System.out.printf("%.2f", price);
    }

}