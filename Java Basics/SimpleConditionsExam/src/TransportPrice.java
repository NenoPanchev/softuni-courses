import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int km = Integer.parseInt(sc.nextLine());
        String dayOrNight = sc.nextLine();
        double price = 0.0;
        if (km < 20) {
            if (dayOrNight.equals("day")) {
                price = 0.7 + km * 0.79;

            } else if (dayOrNight.equals("night")) {
                price = .7 + km * .9;
            }
        } else if (km < 100) {
            price = km * .09;
        } else
            price = km * .06;
        System.out.println(price);
    }
}
