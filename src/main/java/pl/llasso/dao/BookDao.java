package pl.llasso.dao;

import org.springframework.stereotype.Repository;
import pl.llasso.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return //entityManager.createQuery("select b from Book b join fetch b.authors")
                entityManager.createQuery("select b from Book b")
                        .getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

        public List<Book> findAllWithPublisher() {
            return entityManager.createQuery("select b from Book b where b.rating = :rating")
                    .getResultList(); //b.publisher IS NOT NULL
        }

        public List<Book> findAllWithAuthor() {
        return entityManager.createQuery("select b from Book b where b.authors IS NOT EMPTY")
                .getResultList(); //WHERE :author MEMBER OF b.authors
    }
//    public List<Book> findWithAnyPublisher(){
//        return entityManager.createQuery("SELECT b from Book b where b.publisher IS NOT EMPTY")
//                .getResultList(); //b.publisher = :publisher   query.setParameter("publisher", publisher); return query.gerResultList
//    }
    public void update(Book book) {
        entityManager.merge(book);
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}