import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Drink> drinkList = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            Drink currentDrink = new Drink();
            currentDrink.name = tokens[0];
            currentDrink.price = Double.parseDouble(tokens[1]);
            currentDrink.quantity = Integer.parseInt(tokens[2]);

            if (drinkList.size() < 1) {
                drinkList.add(currentDrink);
            } else {
                boolean isNew = true;
                for (int i = 0; i < drinkList.size(); i++) {
                    if (drinkList.get(i).name.equals(currentDrink.name)) {
                        drinkList.get(i).price = currentDrink.price;
                        drinkList.get(i).quantity += currentDrink.quantity;
                        isNew = false;
                    }
                }
                if (isNew) drinkList.add(currentDrink);
            }
            input = scan.nextLine();
        }
        LinkedHashMap<String, Double> drinkPrice = new LinkedHashMap<>();

        for (int i = 0; i < drinkList.size(); i++) {
            double totalPrice = drinkList.get(i).quantity * drinkList.get(i).price;
            drinkPrice.put(drinkList.get(i).name, totalPrice);
        }
        drinkPrice
                .forEach((drink, price) -> System.out.printf("%s -> %.2f%n", drink, price));
    }
    static class Drink {
        String name;
        double price;
        int quantity;

        Drink (){}

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public Drink(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }
}
