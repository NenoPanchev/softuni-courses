import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Article article = new Article();
        String name = scan.nextLine();
        String[] originalContent = name.split(", ");
        article.setTitle(originalContent[0]);
        article.setContent(originalContent[1]);
        article.setAuthor(originalContent[2]);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(": ");
            switch (tokens[0]) {
                case "Edit":
                    article.setContent(tokens[1]); break;
                case "ChangeAuthor":
                    article.setAuthor(tokens[1]); break;
                case "Rename":
                    article.setTitle(tokens[1]); break;
            }
        }
        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
    static class Article {
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        String title;
        String content;
        String author;
    }
}
