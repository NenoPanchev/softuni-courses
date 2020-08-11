import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String command = scan.nextLine();
        double price = 0;
        double totalSpent = 0;

        while (!command.equals("Game Time")){
            if (command.equals("OutFall 4") || command.equals("CS: OG") || command.equals("Zplinter Zell")
                    || command.equals("Honored 2") || command.equals("RoverWatch") ||
                    command.equals("RoverWatch Origins Edition")){
                switch (command){
                    case "OutFall 4": price = 39.99; break;
                    case "CS: OG": price = 15.99; break;
                    case "Zplinter Zell": price = 19.99; break;
                    case "Honored 2": price = 59.99; break;
                    case "RoverWatch": price = 29.99; break;
                    case "RoverWatch Origins Edition": price = 39.99; break;
                }
                if (budget >= price){
                    budget -= price;
                    totalSpent += price;
                    System.out.printf("Bought %s%n", command );
                } else if (budget < price) System.out.println("Too Expensive");
            }
            else System.out.println("Not Found");
            command = scan.nextLine();
        }
        if (budget == 0) System.out.println("Out of money!");
        else System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget);
    }
}
