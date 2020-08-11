import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");
        for (String untrimmedTicket : tickets) {
            String ticket = untrimmedTicket.trim();
            if (ticket.length() != 20)
                System.out.println("invalid ticket");
            else {
                if (!ticket.contains("$$$$$$") && !ticket.contains("######") &&
                !ticket.contains("@@@@@@") && !ticket.contains("^^^^^^")) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                } else {
                    char symbol = getSymbol(ticket);
                    printWinning(ticket, symbol);
                }

            }
        }
    }
    static char getSymbol(String ticket) {
        char symbol = 0;
        if (ticket.contains("$$$$$$")) {
            ticket.replaceAll("$$$$$$", "");
            if (ticket.length() >= 8)
            symbol = '$';
        }
        if (ticket.contains("@@@@@@")) {
            ticket.replaceAll("@@@@@@", "");
            if (ticket.length() >= 8)
                symbol = '@';
        }
        if (ticket.contains("######")) {
            ticket.replaceAll("######", "");
            if (ticket.length() >= 8)
                symbol = '#';
        }
        if (ticket.contains("^^^^^^")) {
            ticket.replaceAll("^^^^^^", "");
            if (ticket.length() >= 8)
                symbol = '^';
        }
        return symbol;
    }
    static void printWinning(String ticket, char symbol) {
        int totalCount = 0;
        for (int i = 0; i < ticket.length(); i++) {
            if (ticket.charAt(i) == symbol)
                totalCount++;
        }
        if (totalCount == 20) {
            System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, symbol);
        } else {
            int firstHalf = 0;
            int counter = 0;
            for (int i = 0; i < ticket.length() / 2; i++) {
                if (ticket.charAt(i) == symbol) {
                    counter++;
                    if (counter > firstHalf) firstHalf = counter;
                }
                else counter = 0;
            }
            int secondHalf = 0;
            int secondCounter = 0;
            for (int i = ticket.length() - 1; i >= ticket.length() / 2; i--) {
                if (ticket.charAt(i) == symbol) {
                    secondCounter++;
                    if (secondCounter > secondHalf) secondHalf = secondCounter;
                }
                else secondCounter = 0;
            }
            if (firstHalf >= 6 && secondHalf >=6)
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, Math.min(firstHalf, secondHalf), symbol);
            else
                System.out.printf("ticket \"%s\" - no match%n", ticket);
        }
    }
}
