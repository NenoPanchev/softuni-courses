import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new TreeSet<>();
        String input = scan.nextLine();
        while (!"PARTY".equals(input)) {
            set.add(input);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"END".equals(input)) {
            set.remove(input);
            input = scan.nextLine();
        }
        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}
