package springdataintroex.services;

import springdataintroex.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getAllAuthorsCount();
    Author findAuthorById(Long id);
    List<Author> findAllAuthorsOrderedByCountOfBooks();
    List<Author> findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990();
}
