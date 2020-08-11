import java.util.Scanner;

public class OldBooks2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wantedBook = scan.nextLine();
        int capacity = Integer.parseInt(scan.nextLine());
        String book = "";
        int counter = 0;

        while (!book.equals(wantedBook)){
            if (counter>=capacity){break;}
            book = scan.nextLine();
            if (wantedBook.equals(book)){break;}
            counter++;

        }
        if (counter>=capacity){
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", capacity);

        } else {
            System.out.printf("You checked %d books and found it.", counter);
        }
    }
}