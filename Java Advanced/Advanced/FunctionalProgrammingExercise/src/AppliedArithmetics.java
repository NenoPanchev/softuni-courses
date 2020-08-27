import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<Integer> add = n -> n + 1;
        UnaryOperator<Integer> multiply = n -> n * 2;
        UnaryOperator<Integer> subtract = n -> n - 1;
        Consumer<List<Integer>> print = list1 -> {
            list1.forEach(n -> System.out.printf("%d ", n));
            System.out.println();};

        String input = scan.nextLine();
        while (!"end".equals(input)) {
            switch (input) {
                case "add":
                    list = list.stream().map(add).collect(Collectors.toList());
                    break;

                case "multiply":
                    list = list.stream().map(multiply).collect(Collectors.toList());
                    break;

                case "subtract":
                    list = list.stream().map(subtract).collect(Collectors.toList());
                    break;

                case "print":
                    print.accept(list);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
