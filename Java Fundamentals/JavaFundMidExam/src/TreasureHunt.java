import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> chestContaminants = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Loot":
                    addIfNonexisting(chestContaminants, command);
                    break;
                case "Drop":
                    putLastIfIndexInRange(chestContaminants, Integer.parseInt(tokens[1]));
                    break;
                case "Steal":
                    removeLastNItemsAndPrintThem(chestContaminants, Integer.parseInt(tokens[1]));
                    break;
            }

            command = scan.nextLine();
        }

        if (chestContaminants.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            String allTreasureItemsLength = "";
            for (int i = 0; i < chestContaminants.size(); i++) {
                allTreasureItemsLength += chestContaminants.get(i);
            }
            double averageTreasureGain = 1.0 * allTreasureItemsLength.length() / chestContaminants.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }

    }
    static void addIfNonexisting(List<String> initialChestItems, String command) {
        List<String> items = Arrays.stream(command.split("\\s+")).collect(Collectors.toList());
        for (int i = 1; i < items.size(); i++) {
            boolean isContained = false;
            for (int j = 0; j < initialChestItems.size(); j++) {
                if (initialChestItems.get(j).equals(items.get(i))) {
                    isContained = true;
                }
            }
            if (!isContained) initialChestItems.add(0, items.get(i));
        }
    }
    static void putLastIfIndexInRange(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.add(list.get(index));
            list.remove(index);
        }
    }
    static void removeLastNItemsAndPrintThem(List<String> list, int count) {
        if (count > list.size())
            count = list.size();
        String stolenItems = "";

        for (int i = 0; i < count; i++) {
            stolenItems += list.get(list.size() - count + i);
            if (i != count - 1) stolenItems += ", ";
            list.remove(list.size() - count + i);
        }
        System.out.println(stolenItems);
    }
}
