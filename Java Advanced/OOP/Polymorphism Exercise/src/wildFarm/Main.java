package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            Animal animal = createCorrectTypeOfAnimal(tokens);
            String[] foodTokens = scan.nextLine().split("\\s+");
            Food food = createCorrectTypeOfFood(foodTokens);
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            input = scan.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal createCorrectTypeOfAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);

            case "Tiger":
                return new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);

            case "Zebra":
                return new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);

            default:
                return new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);
        }
    }

    private static Food createCorrectTypeOfFood(String[] foodTokens) {
        switch (foodTokens[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodTokens[1]));

            default:
                return new Meat(Integer.parseInt(foodTokens[1]));
        }
    }
}
