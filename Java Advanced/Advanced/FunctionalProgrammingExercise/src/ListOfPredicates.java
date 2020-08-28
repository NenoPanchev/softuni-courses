import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = readList(scan);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisibleToNumbers = num -> {
            for (Integer n : numbers) {
                if (num % n != 0) {
                    return false;
                }
            }
            return true;
        };

        list.stream()
                .filter(isDivisibleToNumbers)
                .forEach(n -> System.out.printf("%d ", n));
    }

    private static List<Integer> readList(Scanner scan) {
        int num = Integer.parseInt(scan.nextLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }
        return list;
    }
}
