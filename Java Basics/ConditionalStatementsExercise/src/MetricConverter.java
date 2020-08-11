import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = Double.parseDouble(sc.nextLine());
        String input = sc.nextLine();
        String output = sc.nextLine();

        switch (input) {
            case "mm":
                if (output.equals("m")) {
                    number = number / 1000;
                } else if (output.equals("cm")) {
                    number = number / 10;
                }
                break;

            case "cm":
                if (output.equals("mm")) {
                    number = number * 10;
                } else if (output.equals("m")) {
                    number = number / 100;
                }
                break;

            case "m":
                if (output.equals("mm")) {
                    number = number * 1000;
                } else if (output.equals("cm")) {
                    number = number * 100;
                }
                break;

        }
        System.out.printf("%.3f", number);
    }
}
