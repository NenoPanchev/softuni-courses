import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivinginKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!"Last note".equals(input)) {
            Pattern pattern = Pattern.compile("^([A-Za-z\\d!@#$?]+)=(\\d+)<<(.+)\\b");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group(1);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isLetter(name.charAt(i))) {
                        sb.append(name.charAt(i));
                    }
                }
                name = sb.toString();
                int lengthOfGeoHashCode = Integer.parseInt(matcher.group(2));
                String geoHashCode = matcher.group(3);
                if (geoHashCode.length() == lengthOfGeoHashCode) {
                    System.out.printf("Coordinates found! %s -> %s%n", name, geoHashCode);
                } else
                    System.out.println("Nothing found!");
            } else
            System.out.println("Nothing found!");
            input = scan.nextLine();
        }
    }
}
