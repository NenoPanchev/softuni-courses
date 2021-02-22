package springdataadvancedqueryingex.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvancedqueryingex.entities.Author;
import springdataadvancedqueryingex.repositories.AuthorRepository;
import springdataadvancedqueryingex.services.AuthorService;
import springdataadvancedqueryingex.utils.FileUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static springdataadvancedqueryingex.constants.GlobalConstants.*;
import static springdataadvancedqueryingex.constants.GlobalConstants.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] names = r.split("\\s+");
                    Author author = new Author(names[0], names[1]);
                    this.authorRepository.saveAndFlush(author);
                });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsOrderedByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/1990", formatter);
        return this.authorRepository.findAllAuthorsWithAtLeastOneBookWithReleaseDateBefore1990(releaseDate);
    }

    @Override
    public List<Author> getNamesOfAuthorsEndingWithEx6(String pattern) {
        return this.authorRepository.findAllByFirstNameEndingWith(pattern);
    }

    @Override
    public List<Map<String, String>> getAllAuthorsOrderedByTotalCopiesOfBooksEx10() {
        return this.authorRepository.findAuthorsOrderedByTotalCountOfBooks();
    }

}
