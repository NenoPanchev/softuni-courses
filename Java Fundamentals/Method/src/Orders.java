import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        result(product, quantity);
    }
    static void result(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":  price = 1.5; break;
            case "water": price = 1; break;
            case "coke": price = 1.4; break;
            case "snacks": price = 2; break;
        }
        System.out.printf("%.2f", price * quantity);
    }
}
