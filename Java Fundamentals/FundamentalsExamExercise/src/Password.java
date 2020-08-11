import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String password = scan.nextLine();
            Pattern pattern = Pattern.compile("([^>]+)>(?<one>\\d{3})\\|(?<two>[a-z]{3})\\|(?<three>[A-z]{3})\\|(?<four>[^><]{3})<\\1");
            Matcher matcher = pattern.matcher(password);
            if (matcher.find())
                System.out.printf("Password: %s%s%s%s%n", matcher.group("one"), matcher.group("two"),
                        matcher.group("three"), matcher.group("four"));
            else
                System.out.println("Try another password!");
        }

    }
}
