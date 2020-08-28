import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(list);
        int num = Integer.parseInt(scan.nextLine());
        Predicate<Integer> isDivisibleByNum = n -> n % num == 0;
        list.stream()
                .filter(isDivisibleByNum.negate())
                .forEach(n -> System.out.printf("%d ", n));
    }
}
