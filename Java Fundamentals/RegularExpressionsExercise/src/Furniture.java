import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double sum = 0;
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile("[>]{2}(?<item>[A-Z][A-Za-z]+)[<]{2}(?<price>\\d+\\.?[\\d+]+)!(?<count>\\d+)\\b");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String item = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                System.out.println(item);
                sum += price * count;
            }

            input = scan.nextLine();
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
