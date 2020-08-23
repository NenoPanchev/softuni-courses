package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Box<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box<>(input);
            list.add(box);
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        Box.swap(list,firstIndex, secondIndex);
        list.forEach(System.out::println);
    }
}
