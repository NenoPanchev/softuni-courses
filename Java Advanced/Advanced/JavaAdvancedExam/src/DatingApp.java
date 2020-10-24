import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            males.push(i);
        }
        arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            females.offer(i);
        }
        int matchesCounter = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0) {
                males.pop();
                continue;
            }
            if (female <= 0) {
                females.poll();
                continue;
            }
            if (male % 25 == 0) {
                males.pop();
                if (males.size() > 0) {
                    males.pop();
                }
                continue;
            }
            if (female % 25 == 0) {
                females.poll();
                if (females.size() > 0) {
                    females.poll();
                }
                continue;
            }

            if (male == female) {
                males.pop();
                matchesCounter++;
            } else {
                males.push(males.pop() - 2);
            }
            females.poll();
        }
        System.out.printf("Matches: %d%n", matchesCounter);
        System.out.print("Males left: ");
        if (males.isEmpty()) {
            System.out.print("none");
        } else {
            while (!males.isEmpty()) {
                System.out.print(males.poll());
                if (!males.isEmpty())
                    System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Females left: ");
        if (females.isEmpty()) {
            System.out.print("none");
        } else {
            while (!females.isEmpty()) {
                System.out.print(females.pop());
                if (!females.isEmpty())
                    System.out.print(", ");
            }
        }
    }
}
