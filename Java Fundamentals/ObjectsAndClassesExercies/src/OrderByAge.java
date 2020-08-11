import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<People> person = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String iD = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            People current = new People(name, iD, age);
            person.add(current);

            input = scan.nextLine();
        }
        person.stream().sorted((p1, p2) -> Integer.compare(p1.age, p2.age))
                .forEach(System.out::println);
    }
}

class People {
    String name;

    public void setAge(int age) {
        this.age = age;
    }

    String iD;
    int age;


    public int getAge() {
        return age;
    }

    public People(String name, String iD, int age) {
        this.name = name;
        this.iD = iD;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.name, this.iD, this.age);
    }
}