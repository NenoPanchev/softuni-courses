import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> list = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        UnaryOperator<Double> addVat = dbl -> dbl * 1.2;
        Function<Double, String> doubleParseStringFunc = dbl -> String.format("%.2f", dbl);
//        list.stream()
//                .map(addVat)
//                .map(doubleParseStringFunc)
//                .forEach(System.out::println);

        for (Double aDouble : list) {
            System.out.println(addVat.andThen(doubleParseStringFunc).apply(aDouble));
        }
    }
}
