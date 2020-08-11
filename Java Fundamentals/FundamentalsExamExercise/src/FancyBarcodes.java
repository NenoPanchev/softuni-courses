import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String text = scan.nextLine();
            Pattern pattern = Pattern.compile("(@#{1,})(?<barcode>[A-Z][A-Za-z\\d]{4,}[A-Z])@#{1,}");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                String group = "00";
                StringBuilder gr = new StringBuilder();
                boolean hasGroup = false;
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        gr.append(barcode.charAt(j));
                        hasGroup = true;
                    }
                }
                if (hasGroup) {
                    group = gr.toString();
                }
                System.out.printf("Product group: %s%n", group);
            } else
                System.out.println("Invalid barcode");
        }

    }
}
