import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("(^|(?<=\\s))[A-Za-z0-9][A-Za-z0-9\\.\\-]*@[A-Za-z]+-?[A-Za-z]*\\.[A-Za-z]*\\.?[A-Za-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            System.out.println(matcher.group());
    }
}
