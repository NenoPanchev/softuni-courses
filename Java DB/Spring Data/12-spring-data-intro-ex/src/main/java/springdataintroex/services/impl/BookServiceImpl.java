package springdataintroex.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintroex.entities.*;
import springdataintroex.repositories.BookRepository;
import springdataintroex.services.AuthorService;
import springdataintroex.services.BookService;
import springdataintroex.services.CategoryService;
import springdataintroex.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static springdataintroex.constants.GlobalConstants.*;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(BOOK_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] data = r.split("\\s+");
                    Book book = createBook(data);
                    this.bookRepository.saveAndFlush(book);
                });
    }

    @Override
    public List<Book> getAllBooksAfter2000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }

    private Book createBook(String[] data) {
        Author author = getRandomAuthor();

        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate releaseDate = LocalDate.parse(data[1], formatter);

        int copies = Integer.parseInt(data[2]);

        BigDecimal price = new BigDecimal(data[3]);

        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

        String title = getTitle(data);

        Set<Category> categories = getRandomCategories();


        Book book = new Book();
        book.setAuthor(author);
        book.setEditionType(editionType);
        book.setReleaseDate(releaseDate);
        book.setCopies(copies);
        book.setPrice(price);
        book.setAgeRestriction(ageRestriction);
        book.setTitle(title);
        book.setCategories(categories);
        return book;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomAuthorId = random.nextInt(this.authorService.getAllAuthorsCount()) + 1;
        return this.authorService.findAuthorById((long) randomAuthorId);
    }

    private String getTitle(String[] data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 5; i < data.length; i++) {
            sb.append(data[i])
                    .append(" ");
        }
        return sb.toString().trim();
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();
        int bound = random.nextInt(3) + 1;
        Set<Category> result = new HashSet<>();

        for (int i = 0; i < bound; i++) {
            int categoryId = random.nextInt(this.categoryService.getAllCategoryCount()) + 1;
            result.add(this.categoryService.getCategoryById((long) categoryId));
        }
        return result;
    }
}
