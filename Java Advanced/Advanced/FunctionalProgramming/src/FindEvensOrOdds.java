import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        scan.nextLine();
        String condition = scan.nextLine();

        List<Integer> list = createList(start, end);

        Predicate<Integer> isOddOrEven = n -> {
            if (condition.equals("odd")) {
                return n % 2 != 0;
            } else
                return n % 2 == 0;
        };
        printFilteredNumbers(isOddOrEven, list);
    }

    private static List<Integer> createList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        return list;
    }

    private static void printFilteredNumbers(Predicate<Integer> predicate, List<Integer> list) {
        for (Integer n : list) {
            if (predicate.test(n))
                System.out.printf("%d ", n);
        }
    }
}
