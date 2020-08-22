package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            double input = Double.parseDouble(scan.nextLine());
            list.add(input);
        }
        double input = Double.parseDouble(scan.nextLine());
        System.out.println(Box.getCountOfBiggerElements(list, input));
    }
}
