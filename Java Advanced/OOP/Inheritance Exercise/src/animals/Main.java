package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String typeOfAnimal = scan.nextLine();
        while (!"Beast!".equals(typeOfAnimal)) {
            String[] tokens = scan.nextLine().split("\\s+");

            tryParsingInputAndAddAnAnimal(animals, typeOfAnimal, tokens);

            typeOfAnimal = scan.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void tryParsingInputAndAddAnAnimal(List<Animal> animals, String typeOfAnimal, String[] tokens) {
        try {
            switch (typeOfAnimal) {
                case "Cat":
                    Cat cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (Integer.parseInt(tokens[1]) <= 0) {
                        System.out.println("Invalid input!");
                    } else
                    animals.add(cat);
                    break;

                case "Dog":
                    Dog dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (Integer.parseInt(tokens[1]) <= 0) {
                        System.out.println("Invalid input!");
                    } else
                    animals.add(dog);
                    break;

                case "Frog":
                    Frog frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (Integer.parseInt(tokens[1]) <= 0) {
                        System.out.println("Invalid input!");
                    } else
                    animals.add(frog);
                    break;

                case "Kitten":
                    Kitten kitten = new Kitten(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (Integer.parseInt(tokens[1]) <= 0) {
                        System.out.println("Invalid input!");
                    } else
                    animals.add(kitten);
                    break;

                case "Tomcat":
                    Tomcat tomcat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    if (Integer.parseInt(tokens[1]) <= 0) {
                        System.out.println("Invalid input!");
                    } else
                    animals.add(tomcat);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
