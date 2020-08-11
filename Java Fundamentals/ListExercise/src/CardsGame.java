import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstHand = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstHand.size() > 0 && secondHand.size() > 0) {
            if (firstHand.get(0).equals(secondHand.get(0))) {
                firstHand.remove(0);
                secondHand.remove(0);
            } else {
                if (firstHand.get(0) > secondHand.get(0)) {
                    firstHand.add(firstHand.get(0));
                    firstHand.add(secondHand.get(0));
                    firstHand.remove(0);
                    secondHand.remove(0);
                } else if (firstHand.get(0) < secondHand.get(0)) {
                    secondHand.add(secondHand.get(0));
                    secondHand.add(firstHand.get(0));
                    firstHand.remove(0);
                    secondHand.remove(0);
                }
            }
        }
        int sum = 0;
        String player = "";
        if (firstHand.size() > secondHand.size()) {
            for (Integer integer : firstHand) {
                sum += integer;
                player = "First";
            }
        } else if (secondHand.size() > firstHand.size()) {
            for (Integer integer : secondHand) {
                sum += integer;
                player = "Second";
            }
        }
        System.out.printf("%s player wins! Sum: %d", player, sum);
    }
}
