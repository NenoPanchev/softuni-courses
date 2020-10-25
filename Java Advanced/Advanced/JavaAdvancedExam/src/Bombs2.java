import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> effects = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(casings::push);

        int datura = 0;
        int cherry = 0;
        int smokeDecoy = 0;

        while (!effects.isEmpty() && !casings.isEmpty() && !isFilled(datura, cherry, smokeDecoy)) {
            int currentEffect = effects.poll();
            int currentCasing = casings.pop();
            int sum = currentCasing + currentEffect;

            switch (sum) {
                case 40:
                    datura++;
                    break;

                case 60:
                    cherry++;
                    break;

                case 120:
                    smokeDecoy++;
                    break;

                default:
                    effects.offerFirst(currentEffect);
                    casings.push(currentCasing - 5);
            }
        }
        if (isFilled(datura, cherry, smokeDecoy)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if (effects.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(effects.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Bomb Casings: ");
        if (casings.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(casings.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoy);
    }

    static boolean isFilled(int datura, int cherry, int smokeDecoy) {
        return datura >= 3 && cherry >= 3 && smokeDecoy >= 3;
    }
}
