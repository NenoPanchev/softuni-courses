package CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Cat> cats = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double number = Double.parseDouble(tokens[2]);
            Cat cat = new Cat(type, name, number);
            cats.add(cat);
            input = scan.nextLine();
        }

        String name = scan.nextLine();

        cats.stream()
                .filter(c -> c.getName().equals(name))
                .forEach(System.out::println);
    }
}
