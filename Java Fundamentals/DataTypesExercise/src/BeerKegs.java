import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        double volume = 0;
        String biggerKeg = "";
        for (int i = 1; i <= num; i++){
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double currentVolume = Math.PI * radius * radius * height;
            if (currentVolume > volume){
                volume = currentVolume;
                biggerKeg = model;
            }
        }
        System.out.println(biggerKeg);
    }
}
