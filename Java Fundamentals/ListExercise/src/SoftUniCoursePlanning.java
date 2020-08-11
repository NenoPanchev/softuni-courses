import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("course start")) {
            String[] tokens = input.split(":");

            switch (tokens[0]) {
                case "Add":
                    if (!getIfItExists(list, tokens[1])) list.add(tokens[1]);
                    break;

                case "Insert":
                   if (!getIfItExists(list, tokens[1])) {
                       list.add(Integer.parseInt(tokens[2]), tokens[1]);
                   }
                   break;

                case "Remove":
                    if (getIfItExists(list, tokens[1])) list.remove(tokens[1]);
                    break;

                case "Swap":
                    if (getIfItExists(list, tokens[1]) && getIfItExists(list, tokens[2])) {
                    swapIndexes(list, tokens[1], tokens[2]);
                    }
                    break;

                case "Exercise":
                    String exercise = tokens[1] + "-Exercise";
                    if (!getExercise(list, tokens[1]) && getIfItExists(list, tokens[1])) {
                        int index = 0;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(tokens[1])) index = i;
                        }
                        list.add(index + 1, exercise);
                    } else if (!getExercise(list, tokens[1]) && !getIfItExists(list, tokens[1])) {
                        list.add(tokens[1]);
                        list.add(exercise);
                    }
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, list.get(i));
        }
    }
    static boolean getIfItExists(List<String> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) return true;
        } return false;
    }
    static void swapIndexes(List<String> list, String first, String second) {
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(first)) {
                firstIndex = i;
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(second)) {
                secondIndex = i;
                break;
            }
        }
        if (getIfItExists(list, first) && !getExercise(list, first) && getIfItExists(list, second) && !getExercise(list, second)) {
            Collections.swap(list, firstIndex, secondIndex);
        } else if (getIfItExists(list, first) && getExercise(list, first) && getIfItExists(list, second) && getExercise(list, second)) {
            Collections.swap(list, firstIndex, secondIndex);
            Collections.swap(list, firstIndex + 1, secondIndex + 1);
        } else if (getIfItExists(list, first) && getExercise(list, first) && getIfItExists(list, second) && !getExercise(list, second)) {
            Collections.swap(list, firstIndex, secondIndex);
            list.add(secondIndex + 1, list.get(firstIndex + 1));
            list.remove(firstIndex + 1);
        } else if (getIfItExists(list, first) && !getExercise(list, first) && getIfItExists(list, second) && getExercise(list, second)) {
            Collections.swap(list, firstIndex, secondIndex);
            list.add(firstIndex + 1, list.get(secondIndex + 1));
            list.remove(secondIndex + 2);
        }
    }
    static boolean getExercise(List<String> list, String name) {
        String exercise = name + "-Exercise";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(exercise))
                return true;
        }
        return false;
    }
}
