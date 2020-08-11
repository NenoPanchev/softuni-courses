import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean ready = false;
        LinkedHashMap<String, Integer> materialCount = new LinkedHashMap<>();

        while (!ready) {
            String input = scan.nextLine();
            String[] farmedMaterials = input.split("\\s+");
            for (int i = 0; i < farmedMaterials.length; i += 2) {
                int quantity = Integer.parseInt(farmedMaterials[i]);
                String material = farmedMaterials[i + 1].toLowerCase();

                materialCount.putIfAbsent(material, 0);
                materialCount.put(material, materialCount.get(material) + quantity);

                for (Map.Entry<String, Integer> entry : materialCount.entrySet()) {
                    if (entry.getValue() >= 250) {
                        switch (entry.getKey()) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                ready = true;
                                entry.setValue(entry.getValue() - 250);
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                ready = true;
                                entry.setValue(entry.getValue() - 250);
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                ready = true;
                                entry.setValue(entry.getValue() - 250);
                                break;
                        }
                    }
                }
                if (ready) break;
            }
        }
        Map<String, Integer> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        Map<String, Integer> junkItems = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : materialCount.entrySet()) {
            switch (entry.getKey()) {
                case "shards":
                case "fragments":
                case "motes":
                    legendaryItems.put(entry.getKey(), entry.getValue());
                    break;
                default:
                    junkItems.put(entry.getKey(), entry.getValue());
            }
        }
        legendaryItems
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    if (a.getValue() - b.getValue() == 0)
                        return a.getKey().compareTo(b.getKey());
                        else
                            return Integer.compare(b.getValue(), a.getValue());
                })
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

                    junkItems
                            .entrySet()
                            .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
