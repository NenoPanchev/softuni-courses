import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int successfulRegistrations = 0;
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("U\\$([A-Z][a-z]{2,})U\\$P@\\$([A-Za-z]{5,}\\d+)P@\\$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String username = matcher.group(1);
                String password = matcher.group(2);
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", username, password);
                successfulRegistrations++;
            } else
                System.out.println("Invalid username or password");
        }

        System.out.print("Successful registrations: ");
        System.out.println(successfulRegistrations);
    }
}
