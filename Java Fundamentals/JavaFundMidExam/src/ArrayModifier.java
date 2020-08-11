import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    int swap = numbers[firstIndex];
                    numbers[firstIndex] = numbers[secondIndex];
                    numbers[secondIndex] = swap;
                    break;

                case "multiply":
                    firstIndex = Integer.parseInt(tokens[1]);
                    secondIndex = Integer.parseInt(tokens[2]);
                    numbers[firstIndex] *= numbers[secondIndex];
                    break;

                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ", Arrays.toString(numbers).replaceAll("[\\[\\]]", "")));
    }
}
