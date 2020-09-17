import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetCover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> list = new ArrayList<>();
        List<Integer> remainingUniverse = new ArrayList<>();
        Arrays.stream(universe).forEach(remainingUniverse::add);

        while (!remainingUniverse.isEmpty()) {
//            int[] longestSet = sets.stream()
//                    .sorted((a, b) -> Integer.compare(getCountOfUniqueNumbers(remainingUniverse, b), getCountOfUniqueNumbers(remainingUniverse, a)))
//                    .findFirst()
//                    .orElse(null);
//
//            for (int i = 0; i < longestSet.length; i++) {
//                if (remainingUniverse.contains(longestSet[i])) {
//                    remainingUniverse.remove(Integer.valueOf(longestSet[i]));
//                }
//            }
//
//            list.add(longestSet);

            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int elem : set) {
                    if (remainingUniverse.contains(elem)) {
                        count++;
                    }
                }
                if (notChosenCount < count){
                    notChosenCount = count;
                    chosenSet = set;
                }
            }
            list.add(chosenSet);
            for (int elem : chosenSet) {
                remainingUniverse.remove(Integer.valueOf(elem));
            }
        }

        return list;
    }

    public static int getCountOfUniqueNumbers(List<Integer> remainingUniverse, int[] set) {
        int count = 0;
        for (int i = 0; i < remainingUniverse.size(); i++) {
            for (int j = 0; j < set.length; j++) {
                if (remainingUniverse.get(i) == set[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
