import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        double total = 0;

        while (num > 0){
           double add = Double.parseDouble(scan.nextLine());
           if (add < 0) {
               System.out.println("Invalid operation!");

               break;
           }
            System.out.printf("Increase: %.2f", add);
            System.out.println();
            total = total + add;
           num--;
        }
        System.out.printf("Total: %.2f", total);
    }
}
