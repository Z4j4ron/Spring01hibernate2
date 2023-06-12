package pl.llasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.llasso.entity.Author;
import pl.llasso.entity.Book;
import pl.llasso.entity.Category;
import pl.llasso.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByRating(int rating);
    List<Book> findByPublisherIsNotNull();
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByAuthorsContains(Author author);
    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);
    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);
    List<Book> findByCategoryId(Long id);
    Optional<Book> findFirstByCategoryOrderByTitle(Category category);

}
