import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        TreeMap<String, HashMap<Integer, Integer>> list = new TreeMap<>();
        TreeMap<String, Integer> health = new TreeMap<>();
        TreeMap<String, Integer> mana = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            health.put(tokens[0], Integer.parseInt(tokens[1]));
            mana.put(tokens[0], Integer.parseInt(tokens[2]));
        }

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split(" - ");
            String command = token[0];
            String name = token[1];

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(token[2]);
                    String spell = token[3];
                    if (mana.get(name) >= neededMP) {
                        mana.put(name, mana.get(name) - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spell, mana.get(name));
                    } else
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spell);
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(token[2]);
                    String attacker = token[3];
                    health.put(name, health.get(name) - damage);
                    if (health.get(name) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                name, damage, attacker, health.get(name));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                        health.remove(name);
                        mana.remove(name);
                    }
                    break;

                case "Recharge":
                    int rechargedMP = Integer.parseInt(token[2]);
                    if (mana.get(name) + rechargedMP > 200) {
                        rechargedMP = 200 - mana.get(name);
                    }
                    mana.put(name, mana.get(name) + rechargedMP);
                    System.out.printf("%s recharged for %d MP!%n", name, rechargedMP);
                    break;

                case "Heal":
                    int healedHP = Integer.parseInt(token[2]);
                    if (health.get(name) + healedHP > 100) {
                        healedHP = 100 - health.get(name);
                    }
                    health.put(name, health.get(name) + healedHP);
                    System.out.printf("%s healed for %d HP!%n", name, healedHP);
                    break;
            }
            input = scan.nextLine();
        }

        health.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    System.out.printf("  HP: %d%n", x.getValue());
                    System.out.printf("  MP: %d%n", mana.get(x.getKey()));
                });
    }
}
