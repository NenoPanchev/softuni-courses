import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        LinkedHashMap<String, String> personEmail = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            String email = scan.nextLine();
            if (!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk") &&
                    !email.toLowerCase().endsWith("com")) {
                personEmail.put(name, email);
            }
            name = scan.nextLine();
        }
        personEmail.entrySet()
                .forEach(x-> System.out.printf("%s -> %s%n", x.getKey(), x.getValue()));
    }
}
