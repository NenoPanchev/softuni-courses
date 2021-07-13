package springdataadvancedqueryingex.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvancedqueryingex.entities.*;
import springdataadvancedqueryingex.repositories.BookRepository;
import springdataadvancedqueryingex.services.AuthorService;
import springdataadvancedqueryingex.services.BookService;
import springdataadvancedqueryingex.services.CategoryService;
import springdataadvancedqueryingex.utils.FileUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static springdataadvancedqueryingex.constants.GlobalConstants.BOOK_FILE_PATH;

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

    @Override
    public List<Book> getBooksTitlesByAgeRestrictionEx1(String ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));
    }

    @Override
    public List<Book> getGoldenBooksWithLessThan5000CopiesEx2() {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000);
    }

    @Override
    public List<Book> getBooksByPriceEx3(String lowPrice, String highPrice) {
        return this.bookRepository.findAllByPriceIsLessThanOrPriceGreaterThan(new BigDecimal(lowPrice),
                new BigDecimal(highPrice));
    }

    @Override
    public List<Book> getBooksNotReleasedInYearEx4(String year) {
        LocalDate before = LocalDate.of(Integer.parseInt(year), 1, 1);
        LocalDate after = LocalDate.of(Integer.parseInt(year), 12, 31);
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after);
    }

    @Override
    public List<Book> getBooksReleasedBeforeDateEx5(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate releaseDate = LocalDate.parse(date, formatter);
        return this.bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> getBooksByPatternContainedInTitleEx7(String pattern) {
        return this.bookRepository.findAllByTitleContaining(pattern);
    }

    @Override
    public List<Book> getBooksByPatternInTheirLastNameEx8(String pattern) {
        return this.bookRepository.findAllByAuthorLastNameStartingWith(pattern);
    }

    @Override
    public int getCountOfBooksWithLongerTitlesThanEx9(int length) {
        return this.bookRepository.countByTitleLongerThan(length);
    }

    @Override
    public List<Map<String, String>> getBookInfoByTitleEx11(String title) {
        return this.bookRepository.selectBookInfoByTitle(title);
    }

    @Override
    public int increaseBookCopiesAndReturnTotalAddedCopiesEx12(String date, String copies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy").withLocale(Locale.US);
        LocalDate date1 = LocalDate.parse(date, formatter);
        int copiesToMultiply = Integer.parseInt(copies);
        int updatedBooks = this.bookRepository.increaseBookCopiesAfterDateByNumber(date1, copiesToMultiply);

        return updatedBooks * copiesToMultiply;
    }

    @Override
    public int deleteBooksWithCopiesLessThanEx13(int copies) {
        return this.bookRepository.deleteBooksByCopiesLessThan(copies);
    }

    @Override
    public int getCountOfWrittenBooksByAuthorsNames(String firstName, String lastName) {
        return this.bookRepository.countBooksByAuthorFirstNameAndAuthorLastName(firstName, lastName);
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
