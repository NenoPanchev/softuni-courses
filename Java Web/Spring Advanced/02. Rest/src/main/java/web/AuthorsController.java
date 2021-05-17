package web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.api.model.Author;
import rest.api.model.Book;
import rest.api.repository.AuthorRepository;
import rest.api.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorsController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        Optional<Author> authorOpt = authorRepository.
                findById(id);
        return authorOpt.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{authorid}/books")
    public List<Book> findBooks(@PathVariable Long authorid) {
        // TODO: 404
        Author author = authorRepository.
                findById(authorid).get();

        return bookRepository.findAllByAuthor(author);
    }


    @PostMapping
    public ResponseEntity<Author> create(
            @RequestBody Author author,
            UriComponentsBuilder ucBuilder) {
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity.created(
                ucBuilder.path("/authors/{authorId}").buildAndExpand(newAuthor.getId()).toUri()
        ).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id) {
        authorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
