package EqualityLogic;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            treeSet.add(person);
            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
