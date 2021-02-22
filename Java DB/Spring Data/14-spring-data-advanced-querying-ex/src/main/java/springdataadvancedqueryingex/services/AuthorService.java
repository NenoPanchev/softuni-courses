package springdataadvancedqueryingex.services;

import springdataadvancedqueryingex.entities.Author;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getAllAuthorsCount();
    Author findAuthorById(Long id);
    List<Author> findAllAuthorsOrderedByCountOfBooks();
    List<Author> findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990();
    List<Author> getNamesOfAuthorsEndingWithEx6(String pattern);
    List<Map<String, String>> getAllAuthorsOrderedByTotalCopiesOfBooksEx10();
}
