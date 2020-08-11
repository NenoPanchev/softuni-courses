import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("[,][ ]*");
        for (String s : input) {
            s = s.trim();
            if (s.length() != 20)
                System.out.println("invalid ticket");
            else {
                String firstHalf = s.substring(0, 10);
                String secondHalf = s.substring(10);
                Pattern pattern = Pattern.compile("\\${6,}|@{6,}|#{6,}|\\^{6,}");
                Matcher first = pattern.matcher(firstHalf);
                Matcher second = pattern.matcher(secondHalf);
                if (first.find() && second.find()) {
                    String leftMatch = first.group();
                    String rightMatch = second.group();
                    if (leftMatch.charAt(0) == rightMatch.charAt(0)) {
                        int length = Math.min(leftMatch.length(), rightMatch.length());
                        char ch = leftMatch.charAt(0);
                        if (rightMatch.length() == 10 && leftMatch.length() == 10)
                            System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", s, ch);
                        else
                            System.out.printf("ticket \"%s\" - %d%c%n", s, length, ch);
                    } else
                        System.out.printf("ticket \"%s\" - no match%n", s);
                } else
                    System.out.printf("ticket \"%s\" - no match%n", s);
            }
        }
    }
}
