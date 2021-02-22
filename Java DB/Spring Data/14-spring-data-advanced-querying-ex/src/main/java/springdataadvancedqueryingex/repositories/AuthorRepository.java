package springdataadvancedqueryingex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import springdataadvancedqueryingex.entities.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT DISTINCT a FROM Author AS a JOIN a.books AS b WHERE b.releaseDate < :date")
    List<Author> findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990(@Param(value = "date") LocalDate date);

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBook();

    List<Author> findAllByFirstNameEndingWith(String pattern);

    @Query("SELECT CONCAT(a.firstName, ' ', a.lastName) AS name, SUM(b.copies) AS copiesSum FROM Author AS a " +
            "JOIN a.books AS b " +
            "GROUP BY a.id " +
            "ORDER BY copiesSum DESC ")
    List<Map<String, String>> findAuthorsOrderedByTotalCountOfBooks();

}
