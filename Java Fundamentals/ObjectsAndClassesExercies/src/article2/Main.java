package article2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Articles2> articles2s = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("title") && !input.equals("author") && !input.equals("content")) {
            String[] tokens = input.split(", ");
            Articles2 art = new Articles2();
            art.title = tokens[0];
            art.content = tokens[1];
            art.author = tokens[2];
            articles2s.add(art);

            input = scan.nextLine();
        }
        switch (input) {
            case "title":
            articles2s.stream().sorted((p1, p2) -> p1.title.compareTo(p2.title))
                    .forEach(System.out::println); break;
            case "content":
                articles2s.stream().sorted((p1, p2) -> p1.content.compareTo(p2.content))
                        .forEach(System.out::println); break;
            case "author":
                articles2s.stream().sorted((p1, p2) -> p1.author.compareTo(p2.author))
                        .forEach(System.out::println); break;
        }
    }
}

class Articles2 {
    @Override
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }

    public Articles2() {

    }

    public Articles2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    String title;
    String content;
    String author;
}
