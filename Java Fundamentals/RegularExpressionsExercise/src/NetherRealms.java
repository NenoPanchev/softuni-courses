import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] demons = scan.nextLine().split("[,][ ]*");
        List<Demon> demonList = new ArrayList<>();
        for (String demon : demons) {
            Pattern validDemonName = Pattern.compile("[^ ]");
            Matcher nameMatcher = validDemonName.matcher(demon);
            Pattern healthPoints = Pattern.compile("[^ ,.\\d+\\-*\\/]");
            Matcher healthP = healthPoints.matcher(demon);
            Pattern positiveNums = Pattern.compile("-?(\\d+\\.?\\d*)");
            Matcher positive = positiveNums.matcher(demon);
            Pattern multiplications = Pattern.compile("\\*");
            Matcher multy = multiplications.matcher(demon);
            Pattern divide = Pattern.compile("\\/");
            Matcher div = divide.matcher(demon);
            if (nameMatcher.find()) {
                demon = demon.replaceAll(" ", "");
                int health = 0;
                StringBuilder hSymbols = new StringBuilder();
                while (healthP.find())
                    hSymbols.append(healthP.group());
                for (int i = 0; i < hSymbols.length(); i++) {
                    health += hSymbols.charAt(i);
                }
                double damage = 0;
                while (positive.find())
                    damage += Double.parseDouble(positive.group());
                while (multy.find())
                    damage *= 2;
                while (div.find())
                    damage /= 2;
                Demon currentDemon = new Demon(demon, health, damage);
                currentDemon.setName(demon);
                currentDemon.setHealth(health);
                currentDemon.setDamage(damage);
                demonList.add(currentDemon);
            }
        }
            demonList.stream()
                    .sorted(Comparator.comparing(Demon::getName))
                    .forEach(s -> System.out.printf("%s - %d health, %.2f damage%n", s.getName(), s.getHealth(), s.getDamage()));
    }

}

class Demon {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    String name;
    int health;
    double damage;

    public Demon(String name, int health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
}