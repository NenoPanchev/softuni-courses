import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([=\\/])([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String current = matcher.group(2);
            travelPoints += current.length();
            destinations.add(current);
        }
        System.out.print("Destinations: ");
        if (destinations.size() > 0)
        System.out.println(String.join(", ", destinations));
        else
            System.out.println();
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
