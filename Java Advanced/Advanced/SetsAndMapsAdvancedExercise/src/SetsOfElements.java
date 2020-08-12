import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        int sizeFirst = scan.nextInt();
        int sizeSecond = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < sizeFirst; i++) {
            String num = scan.nextLine();
            firstSet.add(num);
        }
        for (int i = 0; i < sizeSecond; i++) {
            String num = scan.nextLine();
            secondSet.add(num);
        }
        while (!firstSet.isEmpty()) {
            String currentNum = firstSet.iterator().next();
            firstSet.remove(currentNum);
            if (secondSet.contains(currentNum))
                System.out.printf("%s ", currentNum);
        }
    }
}
