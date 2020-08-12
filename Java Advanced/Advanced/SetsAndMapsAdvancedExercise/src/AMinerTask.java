import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String resource = scan.nextLine();
        LinkedHashMap<String, Integer> materialQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            materialQuantity.putIfAbsent(resource, 0);
            materialQuantity.put(resource, materialQuantity.get(resource) + quantity);

            resource = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry : materialQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
