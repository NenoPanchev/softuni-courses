import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentData = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            continentData.putIfAbsent(continent, new LinkedHashMap<>());
            continentData.get(continent).putIfAbsent(country, new ArrayList<>());
            continentData.get(continent).get(country).add(city);
        }
        continentData.entrySet()
                .forEach(continent -> {
                    System.out.printf("%s:%n", continent.getKey());
                    continent.getValue().entrySet()
                            .forEach(country -> {
                                System.out.printf("%s -> %s%n", country.getKey(), country.getValue().toString().replaceAll("[\\[\\]]", ""));
                            });
                });
    }
}
