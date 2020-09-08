import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> vegetables = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int saladCalories = calories.peek();
            while (saladCalories > 0 && !vegetables.isEmpty()) {
                String v = vegetables.pop();
                int vegCalories = 0;
                switch (v) {
                    case "tomato":
                        vegCalories = 80;
                        break;
                    case "carrot":
                        vegCalories = 136;
                        break;
                    case "lettuce":
                        vegCalories = 109;
                        break;
                    case "potato":
                        vegCalories = 215;
                        break;
                }
                saladCalories -= vegCalories;

            }
            System.out.printf("%d ", calories.pop());

        }
        System.out.println();
        while (!calories.isEmpty()) {
            System.out.printf("%d ", calories.pop());
        }
        while (!vegetables.isEmpty()) {
            System.out.printf("%s ", vegetables.pop());
        }
    }
}
