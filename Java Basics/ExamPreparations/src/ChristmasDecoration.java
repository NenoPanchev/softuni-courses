import java.util.Scanner;

public class ChristmasDecoration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int budget = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        while (!command.equals("Stop")){
            int price = 0;
            for (int i = 0; i < command.length(); i++){
                char letter = command.charAt(i);
                int charValue = letter;
                price += charValue;
            }
            if (budget >= price){
                budget-= price;
                System.out.println("Item successfully purchased!");
            } else {
                System.out.println("Not enough money!");
                break;
            }
            command = scan.nextLine();
        }
        if (command.equals("Stop"))
            System.out.printf("Money left: %d", budget);
    }
}
