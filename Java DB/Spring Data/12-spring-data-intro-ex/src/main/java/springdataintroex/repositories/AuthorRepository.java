package springdataintroex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springdataintroex.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT DISTINCT a FROM Author AS a JOIN a.books AS b WHERE b.releaseDate < :date")
    List<Author> findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990(@Param(value = "date") LocalDate date);

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBook();


}
