import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Integer> cityPeople = new TreeMap<>();
        TreeMap<String, Integer> cityGold = new TreeMap<>();
        String cities = scan.nextLine();
        while (!cities.equals("Sail")) {
            String[] tokens = cities.split("\\|\\|");
            String name = tokens[0];
            int people = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            cityPeople.putIfAbsent(name, 0);
            cityPeople.put(name, cityPeople.get(name) + people);
            cityGold.putIfAbsent(name, 0);
            cityGold.put(name, cityGold.get(name) + gold);
            cities = scan.nextLine();
        }
        String actions = scan.nextLine();
        while (!actions.equals("End")) {
            String[] token = actions.split("=>");
            String command = token[0];
            String town = token[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(token[2]);
                    int gold = Integer.parseInt(token[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    cityPeople.put(town, cityPeople.get(town) - people);
                    cityGold.put(town, cityGold.get(town) - gold);
                    if (cityPeople.get(town) <= 0 || cityGold.get(town) <= 0) {
                        cityPeople.remove(town);
                        cityGold.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;

                case "Prosper":
                    int gld = Integer.parseInt(token[2]);
                    if (gld < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cityGold.put(town, cityGold.get(town) + gld);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gld, town, cityGold.get(town));
                    }
            }

            actions = scan.nextLine();
        }
        if (cityGold.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityGold.size());
            cityGold.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(x -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                                x.getKey(), cityPeople.get(x.getKey()), x.getValue());
                    });
        } else
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
    }
}
