import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Contains":
                    int num = Integer.parseInt(tokens[1]);
                    printContains(numbers, num);
                    break;
                case "Print":
                    String type = tokens[1];
                    printAllOddOrEvenNumbers(numbers, type);
                    break;
                case "Get":
                    System.out.println(getSum(numbers));
                    break;
                case "Filter":
                    String sign = tokens[1];
                    int n = Integer.parseInt(tokens[2]);
                    printAllQualifiedNumbers(numbers, sign, n);
                    break;
            }
            command = scan.nextLine();
        }
    }
    static void printContains(List<Integer> list, int num) {
        for (Integer integer : list) {
            if (integer == num) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No such number");
    }
    static void printAllOddOrEvenNumbers(List<Integer> list, String type) {
        if (type.equals("even")) {
            for (Integer integer : list) {
               if (integer % 2 == 0) {
                   System.out.print(integer + " ");
               }
            }
            System.out.println();
        }
        if (type.equals("odd")) {
            for (Integer integer : list) {
                if (integer % 2 != 0) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        }
    }
    static int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    static void printAllQualifiedNumbers(List<Integer> list, String sign, int num) {
        if (sign.equals(">")) {
            for (Integer integer : list) {
                if (integer > num) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        } else  if (sign.equals(">=")) {
            for (Integer integer : list) {
                if (integer >= num) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        } else  if (sign.equals("<")) {
            for (Integer integer : list) {
                if (integer < num) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        } else  if (sign.equals("<=")) {
            for (Integer integer : list) {
                if (integer <= num) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        }
    }
}
