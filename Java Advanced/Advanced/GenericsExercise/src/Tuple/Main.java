package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tuple<String, Integer, Double> person = new Tuple<>("Pesho", 29, 73.0);
        System.out.println(person.getItem1());
        System.out.println(person.getItem2());
        System.out.println(person.getItem3());
    }
}
