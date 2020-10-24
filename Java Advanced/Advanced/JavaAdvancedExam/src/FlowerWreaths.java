import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> roses = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        int wreaths = 0;
        int totalFlowers = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int rose = roses.peek();
            int lilly = lilies.peek();
            if (rose + lilly > 15) {
                lilies.push(lilies.pop() - 2);
            } else if (rose + lilly == 15) {
                roses.poll();
                lilies.pop();
                wreaths++;
            } else {
                totalFlowers += roses.poll() + lilies.pop();
            }
        }
        wreaths += totalFlowers / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
