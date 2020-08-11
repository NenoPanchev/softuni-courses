import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int singerMoney = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int totalGuests = 0;
        int totalMoney = 0;

        while (!command.equals("The restaurant is full")){
            int guests = Integer.parseInt(command);
            if (guests < 5)
                totalMoney += (guests * 100);
            else totalMoney += (guests * 70);
            totalGuests += guests;
            command = scan.nextLine();
        }
        if (totalMoney >= singerMoney){
            System.out.printf("You have %d guests and %d leva left.", totalGuests, totalMoney - singerMoney);
        } else
            System.out.printf("You have %d guests and %d leva income, but no singer.", totalGuests, totalMoney);
    }
}
