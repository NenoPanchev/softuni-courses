import java.util.Scanner;

public class Tickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String type = scan.nextLine();
        int people = Integer.parseInt(scan.nextLine());
        double ticket = 0;
        double travelBudget = 1;

        if (type.equals("VIP"))
            ticket = 499.99;
        else if (type.equals("Normal"))
            ticket = 249.99;

        double totalTickets = ticket * people;

        if (people > 0 && people <= 4)
            travelBudget = .25;
        else if (people <= 9)
            travelBudget = .4;
        else if (people <= 24)
            travelBudget = .5;
        else if (people <= 49)
            travelBudget = .6;
        else if (people >= 50)
            travelBudget = .75;

        double ticketBudget = budget * travelBudget;

        if (ticketBudget >= totalTickets)
            System.out.printf("Yes! You have %.2f leva left.", ticketBudget - totalTickets);
        else
            System.out.printf("Not enough money! You need %.2f leva.", totalTickets - ticketBudget);
    }
}
