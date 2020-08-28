import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> isShortEnough = s -> s.length() <= num;

        list.stream()
                .filter(isShortEnough)
                .forEach(System.out::println);
    }
}
