import java.util.Scanner;

public class BiscuitFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dailyBiscuitsPerWorker = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        double biscuitsOfOtherFactoryPer30Days = Integer.parseInt(scan.nextLine());
        double monthlyBiscuits = 20 * dailyBiscuitsPerWorker * workers +
                10 * (Math.floor(dailyBiscuitsPerWorker * workers * 0.75));

        System.out.printf("You have produced %.0f biscuits for the past month.%n", monthlyBiscuits);
        double difference = (Math.max(monthlyBiscuits, biscuitsOfOtherFactoryPer30Days) -
                Math.min(monthlyBiscuits, biscuitsOfOtherFactoryPer30Days)) /
                biscuitsOfOtherFactoryPer30Days * 100;
        if (monthlyBiscuits > biscuitsOfOtherFactoryPer30Days) {
            System.out.printf("You produce %.2f percent more biscuits.%n", difference);
        } else if (monthlyBiscuits < biscuitsOfOtherFactoryPer30Days) {
            System.out.printf("You produce %.2f percent less biscuits.%n", difference);
        }
    }
}
