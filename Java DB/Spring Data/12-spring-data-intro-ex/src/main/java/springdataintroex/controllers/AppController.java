package springdataintroex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataintroex.entities.Book;
import springdataintroex.services.AuthorService;
import springdataintroex.services.BookService;
import springdataintroex.services.CategoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        System.out.println("Здравейте!");

        while (true) {
            System.out.println("Въведете номера на задачата, която искате да проверите или 0 за изход:");
            int problem = 0;

            try {
                problem = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }


            try {
                switch (problem) {
                    case 0:
                        System.out.println("Довиждане!");
                        System.exit(0);
                    case 1:
                        ex1();
                        break;
                    case 2:
                        ex2();
                        break;
                    case 3:
                        ex3();
                        break;
                    case 4:
                        ex4();
                        break;
                    default:
                        System.out.println("Грешен номер. Опитайте отново:");
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {

            }
            System.out.println();
        }
    }

    private void ex1() {
        this.bookService.getAllBooksAfter2000()
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void ex2() {
        this.authorService.findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990()
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }


    private void ex3() {
        this.authorService.findAllAuthorsOrderedByCountOfBooks()
                .forEach(author -> System.out.printf("%s %s: %d%n", author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()));
    }


    private void ex4() {
        this.bookService.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
                .forEach(book -> System.out.printf("%s, %s, %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }
}
