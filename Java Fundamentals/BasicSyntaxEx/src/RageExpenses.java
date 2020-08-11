import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        int headsets = lostGames / 2;
        int mouses = lostGames / 3;
        int keyboards = lostGames / 6;
        int displays = lostGames / 12;
        double sum = headsetPrice * headsets + mousePrice * mouses + keyboardPrice * keyboards + displayPrice * displays;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
