import java.util.*;
import java.util.stream.Collectors;

public class SummerCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> ingredientValue = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktailNumbers = new TreeMap<>();

        while (!ingredientValue.isEmpty() && !freshness.isEmpty()) {
            int currentIngredient = ingredientValue.peek();
            int currentFreshness = freshness.peek();
            if (currentIngredient == 0) {
                ingredientValue.poll();
                continue;
            }
            if (currentFreshness == 0) {
                freshness.pop();
                continue;
            }
            int sum = currentFreshness * currentIngredient;
            switch (sum) {
                case 150:
                    cocktailNumbers.putIfAbsent("Mimosa", 0);
                    cocktailNumbers.put("Mimosa", cocktailNumbers.get("Mimosa") + 1);
                    ingredientValue.poll();
                    freshness.pop();
                    break;

                case 250:
                    cocktailNumbers.putIfAbsent("Daiquiri", 0);
                    cocktailNumbers.put("Daiquiri", cocktailNumbers.get("Daiquiri") + 1);
                    ingredientValue.poll();
                    freshness.pop();
                    break;

                case 300:
                    cocktailNumbers.putIfAbsent("Sunshine", 0);
                    cocktailNumbers.put("Sunshine", cocktailNumbers.get("Sunshine") + 1);
                    ingredientValue.poll();
                    freshness.pop();
                    break;

                case 400:
                    cocktailNumbers.putIfAbsent("Mojito", 0);
                    cocktailNumbers.put("Mojito", cocktailNumbers.get("Mojito") + 1);
                    ingredientValue.poll();
                    freshness.pop();
                    break;

                default:
                    freshness.pop();
                    ingredientValue.offer(ingredientValue.poll() + 5);
            }
        }
        if (cocktailNumbers.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientValue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientValue) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }

        cocktailNumbers.entrySet().forEach(c -> System.out.printf("# %s --> %d%n", c.getKey(), c.getValue()));
    }
}
