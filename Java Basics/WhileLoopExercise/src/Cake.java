import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int pieces = 0;
        int totalEaten = 0;
        while (totalEaten <= (width * length)){
            String command = scan.nextLine();
            if (command.equals("STOP")){break;}
            pieces = Integer.parseInt(command);
            totalEaten += pieces;
        }
        if (totalEaten <= (width * length)){
            System.out.printf("%d pieces are left.", width * length - totalEaten);
        } else System.out.printf("No more cake left! You need %d pieces more.", totalEaten - width * length);
    }
}
