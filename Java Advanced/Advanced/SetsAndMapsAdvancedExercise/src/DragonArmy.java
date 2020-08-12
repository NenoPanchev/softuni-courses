import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, double[]>> dragonData = new LinkedHashMap<>();
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] token = input.split(" ");
            String color = token[0];
            String name = token[1];
            double damage;
            double health;
            double armor;
            if (token[2].equals("null"))
                damage = 45;
            else damage = Double.parseDouble(token[2]);

            if (token[3].equals("null"))
                health = 250;
            else health = Double.parseDouble(token[3]);

            if (token[4].equals("null"))
                armor = 10;
            else armor = Double.parseDouble(token[4]);
            dragonData.putIfAbsent(color, new TreeMap<>());
            dragonData.get(color).put(name, new double[]{damage, health, armor});
        }

        dragonData.entrySet()
                .forEach(type -> {
                    double avgDamage = getAverageStat(type.getValue(), 0);
                    double avgHealth = getAverageStat(type.getValue(), 1);
                    double avgArmor = getAverageStat(type.getValue(), 2);
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), avgDamage, avgHealth, avgArmor);
                    type.getValue().entrySet()
                            .forEach(s -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                                    s.getKey(), s.getValue()[0], s.getValue()[1], s.getValue()[2]));

                });
    }
    static double getAverageStat(TreeMap<String, double[]> list, Integer stat) {
        double total = 0;
        for (Map.Entry<String, double[]> entry : list.entrySet()) {
            total += entry.getValue()[stat];
        }
        return total / list.size();
    }
}
