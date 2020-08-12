import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> periodicTable = new TreeSet<>();
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            periodicTable.addAll(Arrays.asList(input));
        }
        System.out.println(String.join(" ", periodicTable));
    }
}
