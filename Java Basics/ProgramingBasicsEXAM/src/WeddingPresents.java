import java.util.Scanner;

public class WeddingPresents {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guests = Integer.parseInt(scan.nextLine());
        int gifts = Integer.parseInt(scan.nextLine());

        int aCount = 0;
        int bCount = 0;
        int vCount = 0;
        int gCount = 0;

        for (int i = 0; i < gifts; i++) {
            String typeOfGift = scan.nextLine();
            switch (typeOfGift) {
                case "A": aCount++; break;
                case "B": bCount++; break;
                case "V": vCount++; break;
                case "G": gCount++; break;
            }
        }
        System.out.printf("%.2f%%%n", 1.0 * aCount / gifts * 100);
        System.out.printf("%.2f%%%n", 1.0 * bCount / gifts * 100);
        System.out.printf("%.2f%%%n", 1.0 * vCount / gifts * 100);
        System.out.printf("%.2f%%%n", 1.0 * gCount / gifts * 100);
        System.out.printf("%.2f%%%n", 1.0 * gifts / guests * 100);
    }
}
