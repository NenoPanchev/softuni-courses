package springdataadvancedqueryingex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import springdataadvancedqueryingex.entities.AgeRestriction;
import springdataadvancedqueryingex.entities.Book;
import springdataadvancedqueryingex.entities.EditionType;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate localDate);
    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);
    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lowPrice, BigDecimal highPrice);
    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate beforeDate, LocalDate afterDate);
    List<Book> findAllByReleaseDateBefore(LocalDate beforeDate);
    List<Book> findAllByTitleContaining(String pattern);

    @Query("SELECT b from Book b JOIN b.author a " +
            "WHERE a.lastName LIKE :pattern%")
    List<Book> findAllByAuthorLastNameStartingWith(@Param("pattern") String pattern);

    @Query("SELECT COUNT(b) FROM Book b WHERE LENGTH(b.title) > :param")
    int countByTitleLongerThan(@Param("param") int length);

    @Query("SELECT b.title AS title, b.editionType AS editionType, b.ageRestriction AS ageRestriction, b.price AS price FROM Book b " +
            "WHERE b.title LIKE %:title%")
    List<Map<String, String>> selectBookInfoByTitle(@Param("title") String title);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :copies " +
            "WHERE b.releaseDate > :date")
    int increaseBookCopiesAfterDateByNumber(@Param("date") LocalDate localDate, @Param("copies") int copies);

    @Transactional
    @Modifying
    int deleteBooksByCopiesLessThan(int copies);

    @Query(value = "CALL bookshop_system.usp_get_count_of_books_written_by_author(:firstName, :lastName);", nativeQuery = true)
    int countBooksByAuthorFirstNameAndAuthorLastName(@Param("firstName") String firstName,
                                                     @Param("lastName") String lastName);
}
