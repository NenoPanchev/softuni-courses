import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Predicate<String> startsWithCapitalLetter = str -> Character.isUpperCase(str.charAt(0));
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(startsWithCapitalLetter)
                .collect(Collectors.toList());
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
