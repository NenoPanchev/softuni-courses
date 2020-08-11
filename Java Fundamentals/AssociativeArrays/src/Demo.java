import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.asList(1,-2, -4, 5, 6);

        List<Integer> positiveNumbers = filter(numbers, integer -> integer > 0);
        List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);
        List<Integer> negativeNumbers = filter(numbers, number -> number < 0);
        for (Integer number : evenNumbers) {
            System.out.print(number + " ");
        }

    }
    private static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            boolean isValid = predicate.test(number);
            if (isValid) {
                numbers.add(number);
            }
        }

        return result;
    }
}


