import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split("\\s+");
        Consumer<String[]> printArray = arr -> {
            for (String s : arr) {
                System.out.println("Sir " + s);
            }
        };
        printArray.accept(names);
    }
}
