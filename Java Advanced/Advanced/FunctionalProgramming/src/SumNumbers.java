import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Function<String, Integer> parseStrToInt = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(parseStrToInt)
                .collect(Collectors.toList());

        System.out.printf("Count = %d%n", numbers.size());
        int sum = numbers.stream()
                .mapToInt(n -> n)
                .sum();

        System.out.printf("Sum = %d%n", sum);
    }
}
