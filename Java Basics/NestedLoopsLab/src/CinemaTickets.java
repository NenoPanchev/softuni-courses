import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieName = "";
        double standard = 0;
        double kid = 0;
        double student = 0;
        int counter = 0;
        double currentCounter = 0;

        while (!movieName.equals("Finish")){
            movieName = scan.nextLine();
            if (movieName.equals("Finish"))break;
            int tickets = Integer.parseInt(scan.nextLine());
            for (int i = 1; i <= tickets; i++){
            String type = scan.nextLine();
            if (type.equals("standard")) standard++;
            if (type.equals("kid")) kid++;
            if (type.equals("student")) student++;
            if (type.equals("End")) break;
                counter++;
                currentCounter++;
            }
            System.out.printf("%s - %.2f%% full.%n", movieName, (1.0 * currentCounter / tickets * 100));
            currentCounter = 0;
        }
        System.out.printf("Total tickets: %d%n", counter);
        System.out.printf("%.2f%% student tickets.%n", student / counter * 100);
        System.out.printf("%.2f%% standard tickets.%n", standard / counter * 100);
        System.out.printf("%.2f%% kids tickets.", kid / counter * 100);
    }
}
