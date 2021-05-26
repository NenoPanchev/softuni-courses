package rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.api.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}