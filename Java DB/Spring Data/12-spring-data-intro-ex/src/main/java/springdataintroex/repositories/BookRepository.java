package springdataintroex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdataintroex.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate localDate);
    List<Book> findAllByReleaseDateBefore(LocalDate localDate);
    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
