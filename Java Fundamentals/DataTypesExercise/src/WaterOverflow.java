import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int totalPoured = 0;
        for (int i = 1; i <= num; i++){
            int litersPoured = Integer.parseInt(scan.nextLine());
            if (totalPoured + litersPoured > 255) System.out.println("Insufficient capacity!");
            else totalPoured += litersPoured;
        }
        System.out.println(totalPoured);
    }
}
