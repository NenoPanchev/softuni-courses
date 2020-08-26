package StrategyPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        TreeSet<Person> byName = new TreeSet<>(new OrderByName());
        TreeSet<Person> byAge = new TreeSet<>(new OrderByAge());

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            byName.add(person);
            byAge.add(person);
        }

        byName.forEach(System.out::println);
        byAge.forEach(System.out::println);
    }
}
