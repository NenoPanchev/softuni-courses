import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalFishes = Integer.parseInt(scan.nextLine());
        String name = scan.nextLine();
        int fishCount = 0;
        double totalMoney = 0;
        while (!name.equals("Stop")){
            double kilos = Double.parseDouble(scan.nextLine());
            fishCount++;
            double moneyPerFish = 0;
            for (int i = 0; i < name.length(); i++){
                moneyPerFish += name.charAt(i);
            }
            if (fishCount % 3 == 0) totalMoney += (moneyPerFish / kilos);
            else totalMoney -= (moneyPerFish / kilos);
            if (fishCount == totalFishes){
                System.out.println("Lyubo fulfilled the quota!");
                break;
            }
            name = scan.nextLine();
        }
        if (totalMoney >= 0)
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", fishCount, totalMoney);
        else System.out.printf("Lyubo lost %.2f leva today.", Math.abs(totalMoney));
    }
}
