import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class CustomComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Arrays.sort(list, new ComparatorEvensThenOdds());
        for (Integer n : list) {
            System.out.printf("%d ", n);
        }
    }
}

class ComparatorEvensThenOdds implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        int sort = first - second;
        if (first % 2 == 0 && second % 2 != 0) {
            sort = -1;
        } else if (first % 2 != 0 && second % 2 == 0) {
            sort = 1;
        }
        return sort;
    }
}
