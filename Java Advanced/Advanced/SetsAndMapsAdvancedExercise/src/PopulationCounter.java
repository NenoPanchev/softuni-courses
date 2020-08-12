import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryPopulation = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.parseLong(tokens[2]);
            countryPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countryPopulation.get(country).put(city, population);
            input = scan.nextLine();
        }
        countryPopulation.entrySet()
                .stream()
                .sorted((a, b) -> {
                    long populationA = a.getValue().values().stream().mapToLong(n -> n).sum();
                    long populationB = b.getValue().values().stream().mapToLong(n -> n).sum();
                    return Long.compare(populationB, populationA);
                }).forEach(x -> {
            System.out.printf("%s (total population: %d)%n", x.getKey(), x.getValue().values().stream().mapToLong(n -> n).sum());
            x.getValue().entrySet()
                    .stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(s -> System.out.printf("=>%s: %d%n", s.getKey(), s.getValue()));
        });
    }
}
