import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        double avg = numbers.stream().mapToDouble(val -> val).average().orElse(0);

        numbers.removeIf(number -> number <= avg);
        if (numbers.size() == 0) {
            System.out.println("No");
        } else {
            Collections.sort(numbers);
            Collections.reverse(numbers);
            if (numbers.size() > 5) {
                for (int i = 5; i < numbers.size(); i++) {
                    numbers.remove(numbers.get(i));
                    i--;
                }
            }
            System.out.println(String.join(" ", numbers.toString().replaceAll("[\\[\\],]", "")));
        }
    }
}
