import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuassTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int size = numbers.size() / 2;
        for (int i = 0; i < size; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
