import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, LinkedHashSet<String>> guestsMeals = new TreeMap<>();
        int totalUnlikedMeals = 0;
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String likeliness = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            if (likeliness.equals("Like")) {
                guestsMeals.putIfAbsent(guest, new LinkedHashSet<>());
                guestsMeals.get(guest).add(meal);
            } else if (likeliness.equals("Unlike")) {
                if (guestsMeals.containsKey(guest)) {
                    if (guestsMeals.get(guest).contains(meal)) {
                        guestsMeals.get(guest).remove(meal);
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        totalUnlikedMeals++;
                    } else
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                } else
                    System.out.printf("%s is not at the party.%n", guest);
            }
            input = scan.nextLine();
        }
        guestsMeals
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(x -> System.out.printf("%s: %s%n", x.getKey(), x.getValue().toString()
                .replaceAll("[\\[\\]]", "")));

        System.out.printf("Unliked meals: %d%n", totalUnlikedMeals);
    }
}
