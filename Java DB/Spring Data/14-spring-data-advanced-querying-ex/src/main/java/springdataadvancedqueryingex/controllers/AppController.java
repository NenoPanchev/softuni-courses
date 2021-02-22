package springdataadvancedqueryingex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataadvancedqueryingex.services.AuthorService;
import springdataadvancedqueryingex.services.BookService;
import springdataadvancedqueryingex.services.CategoryService;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        System.out.println("Hello, fellow student :)");

        while (true) {
            System.out.println("Enter the number of problem you wish to check or 0 to exit:");
            int problem = Integer.parseInt(bufferedReader.readLine());

            try {
                switch (problem) {
                    case 0:
                        System.out.println("Goodbye! :)");
                        System.exit(0);

                    case 1:
                        System.out.println("Enter age restriction:");
                        this.bookService.getBooksTitlesByAgeRestrictionEx1(bufferedReader.readLine())
                                .forEach(book -> System.out.println(book.getTitle()));
                        break;

                    case 2:
                        this.bookService.getGoldenBooksWithLessThan5000CopiesEx2()
                        .forEach(book -> System.out.println(book.getTitle()));
                        break;

                    case 3:
                        System.out.println("Enter low price:");
                        String lowPrice = bufferedReader.readLine();
                        System.out.println("Enter high price:");
                        String highPrice = bufferedReader.readLine();

                        this.bookService.getBooksByPriceEx3(lowPrice, highPrice)
                        .forEach(book -> System.out.printf("%s - $%.2f%n", book.getTitle(), book.getPrice()));
                        break;

                    case 4:
                        System.out.println("Enter a year to get all the books not released in:");

                        this.bookService.getBooksNotReleasedInYearEx4(bufferedReader.readLine())
                                .forEach(book -> System.out.println(book.getTitle()));
                        break;

                    case 5:
                        System.out.println("Enter a date in the format dd-MM-yyyy:");

                        this.bookService.getBooksReleasedBeforeDateEx5(bufferedReader.readLine())
                                .forEach(book -> System.out.printf("%s %s %.2f%n",
                                        book.getTitle(), book.getEditionType(), book.getPrice()));

                        break;

                    case 6:
                        System.out.println("Enter a pattern to get all authors which first names ends with:");
                        this.authorService.getNamesOfAuthorsEndingWithEx6(bufferedReader.readLine())
                                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
                        break;

                    case 7:
                        System.out.println("Enter a pattern to get all books in which titles it's contained:");
                        this.bookService.getBooksByPatternContainedInTitleEx7(bufferedReader.readLine())
                                .forEach(book -> System.out.println(book.getTitle()));
                        break;

                    case 8:
                        System.out.println("Enter a pattern to get all books which author's last name starts with:");
                        this.bookService.getBooksByPatternInTheirLastNameEx8(bufferedReader.readLine())
                                .forEach(book -> System.out.printf("%s (%s %s)%n",
                                        book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
                        break;

                    case 9:
                        System.out.println("Enter length to get the count of books with longer titles:");
                        System.out.println(this.bookService.getCountOfBooksWithLongerTitlesThanEx9(Integer.parseInt(bufferedReader.readLine())));
                        break;

                    case 10:
                        List<Map<String, String>> list = this.authorService.getAllAuthorsOrderedByTotalCopiesOfBooksEx10();
                                list.forEach(result -> {
                                    System.out.printf("%s - %s%n", result.get("name"), result.get("copiesSum"));
                                });
                        break;

                    case 11:
                        System.out.println("Enter book title to get its info:");
                        List<Map<String, String>> bookInfo = this.bookService.getBookInfoByTitleEx11(bufferedReader.readLine());
                        bookInfo.forEach(result -> {
                            System.out.printf("%s %s %s %s%n",
                                    result.get("title"), result.get("editionType"),
                                    result.get("ageRestriction"), result.get("price"));
                        });
                        break;

                    case 12:
                        System.out.println("Enter a date in the format '01 Jan 2000':");
                        String date = bufferedReader.readLine();
                        System.out.println("Enter copies to add to each valid book:");
                        String numberOfCopiesToAdd = bufferedReader.readLine();

                        System.out.println(this.bookService.increaseBookCopiesAndReturnTotalAddedCopiesEx12(date, numberOfCopiesToAdd));
                        break;

                    case 13:
                        System.out.println("Enter a number to delete all books with fewer copies:");
                        System.out.println(this.bookService.deleteBooksWithCopiesLessThanEx13(Integer.parseInt(bufferedReader.readLine())) + " books removed.");
                        break;

                    case 14:
                        System.out.println("Be sure to set the name of your stored procedure in the last method of my BookRepository");

                        System.out.println("Enter both names of an author to get the count of written books by them:");
                        String[] authorNames = bufferedReader.readLine().split("\\s+");
                        System.out.printf("%s %s has written %d books%n",
                                authorNames[0], authorNames[1],
                                this.bookService.getCountOfWrittenBooksByAuthorsNames(authorNames[0], authorNames[1]));
                        break;

                    default:
                        System.out.println("Incorrect exercise. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
