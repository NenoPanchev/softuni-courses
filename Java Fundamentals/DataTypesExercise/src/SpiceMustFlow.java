import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int days = 0;
        int sum = 0;
        while (startingYield >= 100) {
            days++;
            sum += startingYield;
            startingYield -= 10;
            if (sum >= 26) sum -= 26;
            else sum = 0;
        }
        if (sum >= 26) sum -= 26;
        else sum = 0;
        System.out.println(days);
        System.out.println(sum);
    }
}
