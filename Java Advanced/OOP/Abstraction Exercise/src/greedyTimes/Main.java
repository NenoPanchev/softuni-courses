
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemsData = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < itemsData.length; i += 2) {
            String itemName = itemsData[i];
            long quantity = Long.parseLong(itemsData[i + 1]);

            String itemType = getItemTypeFrom(itemName);
            long bagCurrentCapacity = bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();

            if (itemType.equals("") || bagCapacity < bagCurrentCapacity + quantity) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum()
                            + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum()
                            + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            createPocketForItemTypeAndAddIn(bag, itemName, quantity, itemType);
        }

        printBagContaining(bag);
    }

    private static void printBagContaining(Map<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static String getItemTypeFrom(String itemName) {
        String itemType = "";
        if (itemName.length() == 3) {
            itemType = "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (itemName.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }
        return itemType;
    }

    private static void createPocketForItemTypeAndAddIn(Map<String, LinkedHashMap<String, Long>> bag, String itemName, long quantity, String itemType) {
        if (!bag.containsKey(itemType)) {
            bag.put(itemType, new LinkedHashMap<>());
        }

        if (!bag.get(itemType).containsKey(itemName)) {
            bag.get(itemType).put(itemName, 0L);
        }


        bag.get(itemType).put(itemName, bag.get(itemType).get(itemName) + quantity);
    }

}