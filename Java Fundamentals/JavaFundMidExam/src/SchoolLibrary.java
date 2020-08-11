import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> books = Arrays.stream(scan.nextLine().split("&")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+\\|\\s+");
            switch (tokens[0]) {
                case "Add Book":
                    if (!books.contains(tokens[1]))
                        books.add(0, tokens[1]);
                    break;
                case "Take Book":
                    books.remove(tokens[1]);
                    break;
                case "Swap Books":
                    if (books.contains(tokens[1]) && books.contains(tokens[2])) {
                        int a = 0;
                        int b = 0;
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).equals(tokens[1]))
                                a = i;
                            if (books.get(i).equals(tokens[2]))
                                b = i;
                        }
                        Collections.swap(books, a, b);
                    }
                    break;
                case "Insert Book":
                    books.add(tokens[1]);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < books.size())
                        System.out.println(books.get(index));
            }

            input = scan.nextLine();
        }
        System.out.print(String.join(", ", books));
    }
}
