package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            list.add(input);
        }
        String input = scan.nextLine();
        System.out.println(Box.getCountOfBiggerElements(list, input));
    }
}
