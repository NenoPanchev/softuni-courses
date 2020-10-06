package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AddCollection first = new AddCollection();
        AddRemoveCollection second = new AddRemoveCollection();
        MyListImpl third = new MyListImpl();

        String[] items = scan.nextLine().split("\\s+");

    }
}
