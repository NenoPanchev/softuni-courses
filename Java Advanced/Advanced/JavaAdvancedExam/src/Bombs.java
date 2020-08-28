import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> effects = new ArrayDeque<>();
        ArrayDeque<Integer> casing = new ArrayDeque<>();
        int[] arr = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            effects.offer(i);
        }
        arr = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            casing.push(i);
        }
        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;

        while ((!effects.isEmpty() && !casing.isEmpty()) && (daturaBombs < 3 || cherryBombs < 3 || smokeDecoyBombs < 3)) {
            int bombEffect = effects.peek();
            int bombCasing = casing.peek();
            int sum = bombEffect + bombCasing;
            if (sum == 120) {
                smokeDecoyBombs++;
                effects.poll();
                casing.pop();
            } else if (sum == 60) {
                cherryBombs++;
                effects.poll();
                casing.pop();
            } else if (sum == 40) {
                daturaBombs++;
                effects.poll();
                casing.pop();
            } else {
                casing.pop();
                casing.push(bombCasing - 5);
            }
        }
        if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (effects.isEmpty()) {
            System.out.print("empty");
        } else {
            while (!effects.isEmpty()) {
                System.out.print(effects.poll());
                if (!effects.isEmpty())
                    System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Bomb Casings: ");
        if (casing.isEmpty()) {
            System.out.print("empty");
        } else {
            while (!casing.isEmpty()) {
                System.out.print(casing.pop());
                if (!casing.isEmpty())
                    System.out.print(", ");
            }
        }
        System.out.println();
        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
