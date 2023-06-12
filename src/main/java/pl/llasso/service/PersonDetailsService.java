package pl.llasso.service;


import org.springframework.stereotype.Service;
import pl.llasso.dao.PersonDao;
import pl.llasso.dao.PersonDetailsDao;
import pl.llasso.entity.Person;
import pl.llasso.entity.PersonDetails;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonDetailsService {
    private PersonDetailsDao personDetailsDao;

    public PersonDetailsService(PersonDetailsDao personDetailsDao) {
        this.personDetailsDao = personDetailsDao;
    }

    public void save(PersonDetails personDetails) {
        personDetailsDao.save(personDetails);
    }

    public PersonDetails findById(Long id) {
        return personDetailsDao.findById(id);
    }

//    public List<Person> findAll() {
//        return personDao.findAll();
//    }

    public void update(PersonDetails personDetails) {
        personDetailsDao.update(personDetails);
    }

    public void deleteById(Long id) {
        personDetailsDao.deleteById(id);
    }
}
