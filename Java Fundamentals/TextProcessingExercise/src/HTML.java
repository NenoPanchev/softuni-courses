import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        String content = scan.nextLine();
        String comment = scan.nextLine();
        System.out.println(getHTMLStyleText(title, "title"));
        System.out.println(getHTMLStyleText(content, "content"));
        while (!comment.equals("end of comments")) {
            System.out.println(getHTMLStyleText(comment, "comment"));
            comment = scan.nextLine();
        }
    }
    static String getHTMLStyleText(String text, String type) {
        String header = "";
        String footer = "";
        if (type.equals("title")) {
            header = "<h1>";
            footer = "</h1>";
        } else if (type.equals("content")) {
            header = "<article>";
            footer = "</article>";
        } else if (type.equals("comment")) {
            header = "<div>";
            footer = "</div>";
        }
        return String.format("%s%n\t%s\n%s", header, text, footer);
    }
}
