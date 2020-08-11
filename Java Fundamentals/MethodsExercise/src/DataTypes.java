import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
            case "int":
                int num = Integer.parseInt(scan.nextLine());
                System.out.println(getInt(num));
                break;
            case "real":
                double number = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f%n", getDouble(number));
                break;
            case "string":
                String string = scan.nextLine();
                System.out.println(getString(string));
                break;
        }

    }
    static int getInt(int num) {
        return num * 2;
    }

    static double getDouble(double num) {
        return num * 1.5;
    }
    static String getString(String string) {
        return "$" + string + "$";
    }
}
