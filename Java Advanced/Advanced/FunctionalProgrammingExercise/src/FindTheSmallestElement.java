import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getMin = list1 -> {
            Integer min = Integer.MAX_VALUE;
            Integer index = 0;
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) <= min) {
                    min = list1.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(getMin.apply(list));
    }
}
