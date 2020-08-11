import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        List<String> list = Arrays.stream(string.split("\\s+"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("3:1")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "merge":
                mergeIndexes(list, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;

                case "divide":
                    divideIndexByInput(list, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
    static void mergeIndexes(List<String> list, int start, int end) {
       if (start < 0) start = 0;
       if (end < 0) end = 0;
       if (end > list.size()) end = list.size() - 1;
       if (start > list.size()) start = list.size() - 1;
        String merged = "";
        for (int i = 0; i < end - start + 1; i++) {
            merged += list.get(start).replaceAll("[\\[\\],]", "");
            list.remove(start);
        }
        list.add(start, merged);
    }

    static void divideIndexByInput(List<String> list, int index, int partitions) {
        List<String> letters = new ArrayList<>();

        for (int i = 0; i < list.get(index).length(); i++) {
            letters.add(list.get(index).charAt(i) + "");
        }
        int length = letters.size();

        for (int i = 0; i < partitions; i++) {
            String merged = "";
            if (i != partitions - 1) {
                int first = (length / partitions);
                for (int j = i; j < first + i; j++) {
                    merged += letters.get(i).replaceAll("[\\[\\],]", "");
                    letters.remove(i);
                }
                letters.add(i, merged);
            }
            else {
                int second = letters.size() - i;
                for (int j = i; j < second + i; j++) {
                    merged += letters.get(i);
                    letters.remove(i);
                }
                letters.add(i, merged);
            }
        }
        list.remove(index);
        for (int i = 0; i < partitions; i++) {
            list.add(index + i, letters.get(i));
        }
    }
}
