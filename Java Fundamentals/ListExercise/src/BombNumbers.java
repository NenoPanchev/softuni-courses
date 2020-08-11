import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int bombNumber = scan.nextInt();
        int radius = scan.nextInt();

        for (int i = 0; i < numbers.size(); i++) {
            if (bombNumber == numbers.get(i)) {
                for (int j = 0; j < radius; j++) {
                    if (i - radius + j >= 0) {
                        numbers.remove(i - radius + j);
                        i--;
                    }
                }
                for (int j = 0; j < radius; j++) {
                    if (i + 1 < numbers.size() && numbers.get(i + 1) != bombNumber) {
                        numbers.remove(i + 1);
                    } else break;
                }
                numbers.remove(i);
                i--;
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
