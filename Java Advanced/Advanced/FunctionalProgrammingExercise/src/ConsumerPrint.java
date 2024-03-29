import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split("\\s+");
        Consumer<String[]> printArray = arr -> {
            for (String s : arr) {
                System.out.println(s);
            }
        };
        printArray.accept(names);
    }
}
