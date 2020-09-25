package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().substring(6).split("\\s+");
        try {
            Pizza pizza = new Pizza(line[0], Integer.parseInt(line[1]));
            line = scan.nextLine().substring(6).split("\\s+");
            Dough dough = new Dough(line[0], line[1], Double.parseDouble(line[2]));
            pizza.setDough(dough);
            String input = scan.nextLine();
            while (!"END".equals(input)) {
                line = input.substring(8).split("\\s+");
                Topping topping = new Topping(line[0], Double.parseDouble(line[1]));
                pizza.addTopping(topping);
                input = scan.nextLine();
            }
            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
