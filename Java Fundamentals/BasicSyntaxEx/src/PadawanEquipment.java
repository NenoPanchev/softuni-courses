import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceLightsabers = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());

        double belts = students * priceBelts - ((students / 6) * priceBelts);
        double robes = priceRobes * students;
        double lightsabers = Math.ceil(students * 1.1) * priceLightsabers;
        double total = belts + robes + lightsabers;

        if (money >= total) System.out.printf("The money is enough - it would cost %.2flv.", total);
        else System.out.printf("Ivan Cho will need %.2flv more.", total - money);
    }
}
