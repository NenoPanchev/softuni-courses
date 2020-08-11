import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        double leftTime = 0;
        double rightTime = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {
            if (numbers.get(i) != 0) leftTime += numbers.get(i);
            else leftTime *= 0.8;
        }

        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            if (numbers.get(i) != 0) rightTime += numbers.get(i);
            else rightTime *= 0.8;
        }
        if (leftTime < rightTime)
            System.out.printf("The winner is left with total time: %.1f", leftTime);
        else if (rightTime < leftTime)
            System.out.printf("The winner is right with total time: %.1f", rightTime);
    }
}
