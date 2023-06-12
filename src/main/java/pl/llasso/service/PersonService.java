package pl.llasso.service;

import org.springframework.stereotype.Service;
import pl.llasso.dao.PersonDao;
import pl.llasso.entity.Person;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }

//    public List<Person> findAll() {
//        return personDao.findAll();
//    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void deleteById(Long id) {
        personDao.deleteById(id);
    }
}
