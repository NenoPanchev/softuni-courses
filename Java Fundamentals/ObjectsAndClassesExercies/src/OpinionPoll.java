import java.util.*;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        List<Person> person = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person currentPerson = new Person(name, age);
            currentPerson.setName(name);
            currentPerson.setAge(age);
            if (age > 30)
            person.add(currentPerson);
        }

        person.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
        .forEach(System.out::println);
    }
    static class Person {
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String name;
        int age;

        @Override
        public String toString() {
            return this.getName() + " - " + this.getAge();
        }
    }
}
