import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("Results")) {
            String[] tokens = input.split(":");
            switch (tokens[0]) {
                case "Add":
                    if (people.isEmpty()) {
                        Person person = new Person();
                        person.setName(tokens[1]);
                        person.setHealth(Integer.parseInt(tokens[2]));
                        person.setEnergy(Integer.parseInt(tokens[3]));
                        people.add(person);
                    } else {
                        for (Person pers : people) {
                            if (pers.getName().equals(tokens[1])) {
                                pers.setHealth(pers.getHealth() + Integer.parseInt(tokens[2]));
                            } else {
                                Person person = new Person();
                                person.setName(tokens[1]);
                                person.setHealth(Integer.parseInt(tokens[2]));
                                person.setEnergy(Integer.parseInt(tokens[3]));
                                people.add(person);
                                break;
                            }
                        }
                    }
                    break;
                case "Attack":
                    String attacker = tokens[1];
                    String defender = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    attack(people, attacker, defender, damage);
                    break;
                case "Delete":
                    if (tokens[1].equals("All")) {
                        people.removeAll(people);
                    } else {
                        for (Person person : people) {
                            if (person.getName().equals(tokens[1])) {
                                people.remove(person);
                                break;
                            }
                        }
                    }
            }
            input = scan.nextLine();
        }
        System.out.printf("People count: %d%n", people.size());
        people.stream()
                .sorted((a,b) -> { if (a.getHealth() == b.getHealth())
                        return a.getName().compareTo(b.getName());
                else return Integer.compare(b.getHealth(), a.getHealth());
                })
                .forEach(p -> System.out.printf("%s - %d - %d%n", p.getName(), p.getHealth(), p.getEnergy()));

    }
    static void attack(List<Person> people, String attacker, String defender, int damage) {
        for (Person person : people) {
            if (person.getName().equals(attacker)) {
                for (Person person1 : people) {
                    if (person1.getName().equals(defender)) {
                        person1.setHealth(person1.getHealth() - damage);
                        if (person1.getHealth() <= 0) {
                            System.out.printf("%s was disqualified!%n", defender);
                            people.remove(person1);

                        }
                        person.setEnergy(person.getEnergy() - 1);
                        if (person.getEnergy() <= 0) {
                            System.out.printf("%s was disqualified!%n", attacker);
                            people.remove(person);
                        }
                        return;
                    }
                }
            }

        }

    }
}

class Person {
    public Person(String name, int health, int energy) {
        this.name = name;
        this.health = health;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    Person(){}
    String name;
    int health;
    int energy;
}

