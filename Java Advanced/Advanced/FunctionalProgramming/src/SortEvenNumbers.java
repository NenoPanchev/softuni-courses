import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(String.join(", ", numbers.toString().replaceAll("[\\[\\]]", "")));
        numbers.sort(Integer::compareTo);
        System.out.println(String.join(", ", numbers.toString().replaceAll("[\\[\\]]", "")));

    }
}
