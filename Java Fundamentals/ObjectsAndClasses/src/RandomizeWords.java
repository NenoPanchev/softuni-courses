import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Random rng = new Random();

        for (int i = 0; i < list.size(); i++) {
            int newPos = rng.nextInt(list.size());
            Collections.swap(list, i, newPos);
        }
        for (String s : list) {
            System.out.printf("%s%n", s);
        }
    }
}
