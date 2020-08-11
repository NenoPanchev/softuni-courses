import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String match = scan.nextLine();
        String typeOfTicket = scan.nextLine();
        int tickets = Integer.parseInt(scan.nextLine());
        String yesOrNo = scan.nextLine();

        double price = 0;

        if (match.equals("Quarter final")){
                switch (typeOfTicket){
                    case "Standard": price = 55.5; break;
                    case "Premium": price = 105.2; break;
                    case "VIP": price = 118.9; break;
                }}
            if (match.equals("Semi final")){
                switch (typeOfTicket){
                    case "Standard": price = 75.88; break;
                    case "Premium": price = 125.22; break;
                    case "VIP": price = 300.4; break;
                }}
            if (match.equals("Final")){
                switch (typeOfTicket){
                    case "Standard": price = 110.1; break;
                    case "Premium": price = 160.66; break;
                    case "VIP": price = 400; break;
                }
        }
        double money = price * tickets;
        if (money <= 2500) {
            if (yesOrNo.equals("Y")) money+= (tickets * 40);
        } else if (money <= 4000){
            money *= 0.9;
            if (yesOrNo.equals("Y")) money+= (tickets * 40);
        } else {
            money *= .75;
        }
        System.out.printf("%.2f", money);
    }
}
