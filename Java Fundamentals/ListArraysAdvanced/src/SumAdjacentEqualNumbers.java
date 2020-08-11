import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Double::parseDouble).collect(Collectors.toList());

        int i = 0;
        while (i < numbers.size() - 1) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) * 2);
                numbers.remove(i + 1);
                i = 0;
            } else
                i++;
        }
        for (Double number : numbers) {
            System.out.print(new DecimalFormat("0.#").format(number) + " ");
        }

    }
}
