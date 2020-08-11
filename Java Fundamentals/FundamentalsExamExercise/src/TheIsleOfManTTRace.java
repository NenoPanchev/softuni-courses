import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("([#$%*&])([A-Za-z]+)\\1=(\\d+)!!(.+)");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String racerName = matcher.group(2);
                int lengthOfGeoHashCode = Integer.parseInt(matcher.group(3));
                String geoHashCode = matcher.group(4);
                if (geoHashCode.length() == lengthOfGeoHashCode) {
                    System.out.printf("Coordinates found! %s -> %s%n", racerName, code(geoHashCode, lengthOfGeoHashCode));
                    return;
                }
            }
            System.out.println("Nothing found!");
        }
    }

    private static String code(String geoHashCode, int key) {
        char[] letters = geoHashCode.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            sb.append((char) (c + key));
        }
        return sb.toString();
    }
}
