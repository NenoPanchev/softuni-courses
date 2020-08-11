import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        double sum = 0;

        while (!command.equals("Start")){
            double coin = Double.parseDouble(command);
            if (coin != 0.1 && coin != 0.2 && coin != 0.5 && coin != 1 && coin != 2)
                System.out.printf("Cannot accept %.2f%n", coin);
            else sum += coin;
            command = scan.nextLine();
        }
        String product = scan.nextLine();
        double price = 0;


        while (!product.equals("End")){
            if (product.equals("End")) break;
            if (!product.equals("Nuts") && !product.equals("Water") && !product.equals("Crisps")
                    && !product.equals("Soda") && !product.equals("Coke")){
                System.out.println("Invalid product");
                product = scan.nextLine();
            }
            else {
                switch (product){
                    case "Nuts": price = 2; break;
                    case "Water": price = .7; break;
                    case "Crisps": price = 1.5; break;
                    case "Soda": price = .8; break;
                    case "Coke": price = 1; break;
                }
                if (sum >= price){
                    sum -= price;
                    System.out.printf("Purchased %s%n", product);
                }
                else System.out.println("Sorry, not enough money");
                product = scan.nextLine();
            }

        }
        System.out.printf("Change: %.2f", sum);
    }
}
