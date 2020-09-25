package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String[] split = scan.nextLine().split(";");
        fillPeopleList(people, split);
        split = scan.nextLine().split(";");
        fillProductList(products, split);

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            split = input.split("\\s+");
            String name = split[0];
            String product = split[1];
            for (Person person : people) {
                if (person.getName().equals(name)) {
                    try {
                        person.buyProduct(products.stream().filter(n -> n.getName().equals(product))
                                .findFirst()
                                .orElse(null));
                        System.out.println(person.getName() + " bought " + product);
                    } catch (IllegalStateException ignore) {
                        System.out.println(ignore.getMessage());
                    }
                }
            }
            input = scan.nextLine();
        }
        people.forEach(System.out::println);
    }

    private static void fillPeopleList(List<Person> people, String[] split) {
        for (String s : split) {
            String[] tokens = s.split("=");
            try {
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void fillProductList(List<Product> products, String[] split) {
        for (String s : split) {
            String[] tokens = s.split("=");
            try {
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
