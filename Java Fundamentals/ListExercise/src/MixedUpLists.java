import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> third = new ArrayList<>();

        int count = Math.min(first.size(), second.size());

        for (int i = 0; i < count; i++) {
            third.add(first.get(i));
            third.add(second.get(second.size() - 1 - i));
        }

        int from = 0;
        int to = 0;
        if (first.size() > second.size()) {
            from = first.get(first.size() - 2);
            to = first.get(first.size() - 1);
        } else if (second.size() > first.size()) {
            from = second.get(0);
            to = second.get(1);
        }
        Collections.sort(third);
        for (Integer integer : third) {
            if (integer > Math.min(from, to) && integer < Math.max(from, to))
                System.out.printf("%d ", integer);
        }
    }
}
