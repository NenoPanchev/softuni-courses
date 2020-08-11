import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        double avg = numbers.stream().mapToDouble(val -> val).average().orElse(0);
        numbers = numbers.stream().filter(a -> a > avg)
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(5).collect(Collectors.toList());
        if (numbers.size() == 0) {
            System.out.println("No");
        } else
            numbers.forEach(n -> System.out.printf("%d ", n));
    }
}
