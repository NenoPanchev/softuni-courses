import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < firstList.size() + secondList.size(); i++) {
            if (i < firstList.size()) {
                resultList.add(firstList.get(i));
            }
            if (i < secondList.size()) {
                resultList.add(secondList.get(i));
            }
        }
        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }

    }
}
