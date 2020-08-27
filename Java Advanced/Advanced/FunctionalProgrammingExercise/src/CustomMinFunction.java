import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> getMin = arr -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer n : arr) {
                if (n < min) {
                    min = n;
                }
            }
            return min;
        };
        System.out.println(getMin.apply(numbers));
    }
}
