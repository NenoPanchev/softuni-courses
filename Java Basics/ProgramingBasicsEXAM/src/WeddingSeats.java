import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lastSector = scan.nextLine();
        char letter = lastSector.charAt(0);
        int rowsInSector = Integer.parseInt(scan.nextLine());
        int seatsInRows = Integer.parseInt(scan.nextLine());
        int seatsInCurrentRow = seatsInRows;
        int totalSeats = 0;

        for (char i = 'A'; i <= letter; i++) {
            for (int j = 1; j <= rowsInSector; j++) {
                if (j % 2 == 0) seatsInCurrentRow += 2;

                for (char k = 'a'; k <= seatsInCurrentRow + 96; k++) {
                    System.out.printf("%c%d%c%n", i, j, k);
                    totalSeats++;
                }

                seatsInCurrentRow = seatsInRows;
            }
            rowsInSector++;
        }
        System.out.println(totalSeats);
    }
}
