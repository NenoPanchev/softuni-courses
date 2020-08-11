import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String string = scan.nextLine();

        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            letters.add(string.charAt(i));
        }
        String finalMessage = "";

        for (int i = 0; i < numbers.size(); i++) {
            int sum = 0;
            int currentNum = numbers.get(i);
            while (currentNum != 0) {
                sum += currentNum % 10;
                currentNum /= 10;
            }

            for (int j = 0; j < (sum % letters.size() + 1); j++) {
                if (j == sum % letters.size()) {
                    finalMessage += letters.get(j);
                    letters.remove(j);
                    break;
                }
            }
        }
        System.out.println(finalMessage);
    }
}
