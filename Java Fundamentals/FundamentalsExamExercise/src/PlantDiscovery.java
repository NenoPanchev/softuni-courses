import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Map<String, Integer> plantRarity = new LinkedHashMap<>();
        Map<String, ArrayList<Double>> plantRatings = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            plantRarity.put(plantName, rarity);
            plantRatings.put(plantName, new ArrayList<>());
        }
        String input = scan.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String command = tokens[0];

            switch (command) {
                case "Rate":
                    String[] subTokens = tokens[1].split("\\s+-\\s+");
                    String plant = subTokens[0];
                    try {
                        double rating = Double.parseDouble(subTokens[1]);
                        if (plantRatings.containsKey(plant)) {
                            plantRatings.get(plant).add(rating);
                        } else {
                            System.out.println("error");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("error");
                        break;
                    }
                    break;

                case "Update":
                    subTokens = tokens[1].split("\\s+-\\s+");
                    plant = subTokens[0];
                    try {
                        int newRarity = Integer.parseInt(subTokens[1]);
                        if (plantRarity.containsKey(plant)) {
                            plantRarity.put(plant, newRarity);
                        } else {
                            System.out.println("error");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("error");
                        break;
                    }
                    break;

                case "Reset":
                    String plantToReset = tokens[1];
                    if (plantRatings.containsKey(plantToReset)) {
                        plantRatings.get(plantToReset).removeAll(plantRatings.get(plantToReset));
                    } else {
                        System.out.println("error");
                        break;
                    }
                    break;

                default:
                    System.out.println("error");
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantRatings
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int sort = Integer.compare(plantRarity.get(b.getKey()), plantRarity.get(a.getKey()));
                    if (sort == 0) {
                        double averageA = a.getValue().stream().mapToDouble(d -> d).average().orElse(0.0);
                        double averageB = b.getValue().stream().mapToDouble(d -> d).average().orElse(0.0);
                        sort = Double.compare(averageB, averageA);
                    }
                    return sort;
                }).forEach(x -> {
                  double average = x.getValue().stream().mapToDouble(d -> d).average().orElse(0.0);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", x.getKey(), plantRarity.get(x.getKey()), average);
        });
    }
}
