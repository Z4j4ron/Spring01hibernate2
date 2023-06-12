package pl.llasso.service;

import org.springframework.stereotype.Service;
import pl.llasso.dao.PublisherDao;
import pl.llasso.entity.Publisher;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PublisherService {

    private PublisherDao publisherDao;

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    public Publisher findById(Long id) {
        return publisherDao.findById(id);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void deleteById(Long id) {
        publisherDao.deleteById(id);
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
}