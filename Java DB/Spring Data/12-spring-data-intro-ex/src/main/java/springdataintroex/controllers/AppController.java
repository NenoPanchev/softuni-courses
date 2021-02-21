package springdataintroex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataintroex.entities.Book;
import springdataintroex.services.AuthorService;
import springdataintroex.services.BookService;
import springdataintroex.services.CategoryService;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        //Query 1
//        this.bookService.getAllBooksAfter2000()
//        .forEach(book -> System.out.println(book.getTitle()));

        //Query 2
        this.authorService.findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990()
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

        //Query 3
//        this.authorService.findAllAuthorsOrderedByCountOfBooks()
//                .forEach(author -> System.out.printf("%s %s: %d%n", author.getFirstName(),
//                        author.getLastName(),
//                        author.getBooks().size()));

        //Query 4
//        this.bookService.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
//        .forEach(book -> System.out.printf("%s, %s, %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }
}
