package springdataadvancedqueryingex.services;

import springdataadvancedqueryingex.entities.Book;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> getAllBooksAfter2000();
    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
    List<Book> getBooksTitlesByAgeRestrictionEx1(String ageRestriction);
    List<Book> getGoldenBooksWithLessThan5000CopiesEx2();
    List<Book> getBooksByPriceEx3(String lowPrice, String highPrice);
    List<Book> getBooksNotReleasedInYearEx4(String year);
    List<Book> getBooksReleasedBeforeDateEx5(String date);
    List<Book> getBooksByPatternContainedInTitleEx7(String pattern);
    List<Book> getBooksByPatternInTheirLastNameEx8(String pattern);
    int getCountOfBooksWithLongerTitlesThanEx9(int length);
    List<Map<String, String>> getBookInfoByTitleEx11(String title);
    int increaseBookCopiesAndReturnTotalAddedCopiesEx12(String date, String copies);
    int deleteBooksWithCopiesLessThanEx13(int copies);
    int getCountOfWrittenBooksByAuthorsNames(String firstName, String lastName);
}
