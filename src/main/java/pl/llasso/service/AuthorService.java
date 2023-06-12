package pl.llasso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.llasso.dao.AuthorDao;
import pl.llasso.entity.Author;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {

    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author) {
        authorDao.save(author);
    }

    public Author findById(Long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
