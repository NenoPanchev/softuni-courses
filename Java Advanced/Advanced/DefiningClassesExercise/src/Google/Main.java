package Google;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<Person> listOfPeople = new LinkedList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String command = tokens[1];
            String name = tokens[2];
            Person person = new Person();
            if (!containsPerson(listOfPeople, personName)) {
                person.setName(personName);
                listOfPeople.add(person);
            } else {
                person = listOfPeople.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
            }


            switch (command) {
                case "company" -> {
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(name, department, salary);
                    person.setCompany(company);
                }
                case "car" -> {
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(name, carSpeed);
                    person.setCar(car);
                }
                case "pokemon" -> {
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(name, pokemonType);
                    person.getPokemonList().add(pokemon);
                }
                case "parents" -> {
                    String parentsBirthday = tokens[3];
                    Parent parent = new Parent(name, parentsBirthday);
                    person.getParentsList().add(parent);
                }
                case "children" -> {
                    String childrenBirthday = tokens[3];
                    Child child = new Child(name, childrenBirthday);
                    person.getChildren().add(child);
                }
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        for (Person person : listOfPeople) {
            if (person.getName().equals(input)) {
                System.out.println(person.getName());
                System.out.println("Company:");
                if (person.getCompany() != null)
                    System.out.printf("%s %s %.2f%n", person.getCompany().getCompanyName(),
                            person.getCompany().getDepartment(), person.getCompany().getSalary());
                System.out.println("Car:");
                if (person.getCar() != null)
                    System.out.printf("%s %d%n", person.getCar().getCarModel(), person.getCar().getCarSpeed());
                System.out.println("Pokemon:");
                if (!person.getPokemonList().isEmpty()) {
                    for (Pokemon pokemon : person.getPokemonList()) {
                        System.out.printf("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType());
                    }
                }
                System.out.println("Parents:");
                if (!person.getParentsList().isEmpty()) {
                    for (Parent parent : person.getParentsList()) {
                        System.out.printf("%s %s%n", parent.getParentName(), parent.getParentBirthday());
                    }
                }
                System.out.println("Children:");
                if (!person.getChildren().isEmpty()) {
                    for (Child child : person.getChildren()) {
                        System.out.printf("%s %s%n", child.getChildName(), child.getChildBirthday());
                    }

                }
                break;
            }
        }

    }

    static boolean containsPerson(List<Person> list, String name) {
        for (Person person : list) {
            if (person.getName().equals(name))
                return true;
        }

        return false;
    }
}
