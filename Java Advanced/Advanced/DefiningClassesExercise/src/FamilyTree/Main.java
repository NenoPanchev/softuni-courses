package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String finalData = scan.nextLine();

        List<Family> peopleList = new ArrayList<>();
        List<String> allData = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {

            if (input.contains("-")) {
                String[] tokens = input.split(" - ");
                allData.add(tokens[0]);
                allData.add(tokens[1]);

            } else {
                String[] tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String date = tokens[2];
                Family person = new Family(new Person(name, date));
                peopleList.add(person);
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < allData.size(); i += 2) {
            String parent = allData.get(i);
            String child = allData.get(i + 1);

            if (!hasChild(getPerson(peopleList, parent), child)) {
                getPerson(peopleList, parent).getChildren().add(getPerson(peopleList, child).getPerson());
            }
            if (!hasParent(getPerson(peopleList, child), parent)) {
                getPerson(peopleList, child).getParents().add(getPerson(peopleList, parent).getPerson());
            }
        }
        System.out.print(getPerson(peopleList, finalData));
    }

    public static Family getPerson(List<Family> list, String data) {
        return list
                .stream()
                .filter(person -> person.getPerson().getName().equals(data) ||
                        person.getPerson().getDate().equals(data))
                .findFirst()
                .get();
    }

    public static boolean hasChild(Family person, String data) {
        for (Person child : person.getChildren()) {
            if (child.getName().equals(data) || child.getDate().equals(data))
                return true;
        }
        return false;
    }

    public static boolean hasParent(Family person, String data) {
        for (Person parent : person.getParents()) {
            if (parent.getName().equals(data) || parent.getDate().equals(data))
                return true;
        }
        return false;
    }
}
