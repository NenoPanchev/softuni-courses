import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Double>> shopProducts = new TreeMap<>();
        String input = scan.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            shopProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopProducts.get(shop).put(product, price);
            input = scan.nextLine();
        }
        shopProducts.entrySet()
                .forEach(s -> {
                    System.out.printf("%s->%n", s.getKey());
                    s.getValue().entrySet()
                            .forEach(p -> System.out.printf("Product: %s, Price: %.1f%n", p.getKey(), p.getValue()));
                });
    }
}
