import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, List<String>> heroSpellbook = new TreeMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String hero = tokens[1];

            switch (command){
                case "Enroll":
                if (!heroSpellbook.containsKey(hero)) {
                    heroSpellbook.put(hero, new LinkedList<>());
                } else
                    System.out.printf("%s is already enrolled.%n", hero);
                break;

                case "Learn":
                    String spell = tokens[2];
                    if (heroSpellbook.containsKey(hero)) {
                        if (heroSpellbook.get(hero).contains(spell)) {
                            System.out.printf("%s has already learnt %s.%n", hero, spell);
                        } else
                            heroSpellbook.get(hero).add(spell);
                    } else
                        System.out.printf("%s doesn't exist.%n", hero);
                    break;

                case "Unlearn":
                    String spellName = tokens[2];
                    if (heroSpellbook.containsKey(hero)) {
                        if (heroSpellbook.get(hero).contains(spellName)) {
                            heroSpellbook.get(hero).remove(spellName);
                        } else
                            System.out.printf("%s doesn't know %s.%n", hero, spellName);
                    } else
                        System.out.printf("%s doesn't exist.%n", hero);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Heroes:");
        heroSpellbook.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(x -> {
                    System.out.printf("== %s: ", x.getKey());
                    System.out.println(String.join(", ", x.getValue()));
                });
    }
}
