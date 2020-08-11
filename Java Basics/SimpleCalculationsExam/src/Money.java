import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scan.nextLine());
        double uan = Double.parseDouble(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());
        double bitToEuro = bitcoins * 1168 / 1.95;
        double uanToEuro = uan * 0.15 * 1.76 / 1.95;
        double total = bitToEuro + uanToEuro;
        double result = total - (total * percent * 0.01);
        System.out.println(result);
    }
}
