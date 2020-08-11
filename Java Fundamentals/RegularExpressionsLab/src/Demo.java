import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern regex = Pattern.compile("\\b(?<day>\\d{1,2}) (?<mont>[A-Z][a-z]+)\\b");
        Matcher matcher = regex.matcher("RegExr was created by gskinner.com, and is proudly hosted by Media Temple.\n" +
                "\n" +
                "Edit the Expression & Text to see matches. Roll over matches or the expression for details. PCRE & JavaScript flavors of RegEx are supported.\n" +
                "\n" +
                "The side bar includes a Cheatsheet, full Reference, and Help. You can also Save & Share with the Community, and view patterns you create or favorite in My Patterns.\n" +
                "\n" +
                "Explore results with the Tools below. Replace & List output custom results. Details lists capture groups. Explain describes your expression in plain English.");
    }
}
