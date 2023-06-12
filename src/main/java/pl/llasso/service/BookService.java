package pl.llasso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.llasso.entity.Author;
import pl.llasso.entity.Book;
import pl.llasso.entity.Category;
import pl.llasso.entity.Publisher;
import pl.llasso.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public void save(Book book) {

        Publisher publisher = book.getPublisher();
        publisherService.save(publisher);

        List<Author> authors = book.getAuthors();

        List<Author> filteredAuthors =
                authors.stream()
                        .filter(a -> authorService.findById(a.getId()) != null)
                        .collect(Collectors.toList());
        book.setAuthors(filteredAuthors);

        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByRating(int rating) {
        return bookRepository.findByRating(rating);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> findByCategory(Category category){
        return bookRepository.findByCategory(category);
    }
    public List<Book> findByCategoryId(Long id){
        return bookRepository.findByCategoryId(id);
    }
    public Optional<Book> findFirstByCategoryOrderByTitle(Category category){
        return bookRepository.findFirstByCategoryOrderByTitle(category);
    }
}
