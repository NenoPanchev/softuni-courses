import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int power = Integer.parseInt(scan.nextLine());
            int distance = Integer.parseInt(scan.nextLine());
            int exhaustionFactor = Integer.parseInt(scan.nextLine());
            int count = 0;
            int initialPower = power;
            while (power >= distance){
                power -= distance;
                count++;
                if (power * 2 == initialPower) {
                    if (exhaustionFactor != 0) power /= exhaustionFactor;
                }
            }
        System.out.println(power);
        System.out.println(count);
    }
}
