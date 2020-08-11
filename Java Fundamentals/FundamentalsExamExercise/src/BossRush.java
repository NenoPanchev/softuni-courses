import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String text = scan.nextLine();
            Pattern pattern = Pattern.compile("\\|([A-Z]{4,})\\|:#([A-Za-z]+ [A-Za-z]+)#");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String name = matcher.group(1);
                String title = matcher.group(2);
                System.out.printf("%s, The %s%n", name, title);
                System.out.printf(">> Strength: %d%n", name.length());
                System.out.printf(">> Armour: %d%n", title.length());
            } else
                System.out.println("Access denied!");
        }
    }
}
