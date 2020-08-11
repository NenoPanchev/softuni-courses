import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person pesho = new Person();
        pesho.age = 1;
        pesho.name = "pesho";
        pesho.lastName = "peshov";
        pesho.PIN = "34343434343";

        Person gosho = new Person();
        gosho.age = 3;
        gosho.name = "gosho";
        gosho.lastName = "goshov";
        gosho.PIN = "66666";

    }
}

    class Person {
        public String getLastName() {
            return lastName;
        }

        String name;
    String lastName;
    int age;
    String PIN;
}