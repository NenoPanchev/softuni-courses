package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> list = new ArrayList<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            list.add(person);
            input = scan.nextLine();
        }
        int num = Integer.parseInt(scan.nextLine());

        if (num < 0 || num >= list.size()) {
            System.out.println("No matches");
        } else {
            int matches = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(num).compareTo(list.get(i)) == 0)
                    matches++;
            }

            System.out.printf("%d ", matches);
            System.out.printf("%d ", list.size() - matches);
            System.out.println(list.size());
        }
    }
}
