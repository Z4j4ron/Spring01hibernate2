package pl.llasso.dao;

import org.springframework.stereotype.Repository;
import pl.llasso.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

//    public List<Person> findAll() {
//        return entityManager.createQuery("select p from Person p")
//                .getResultList();
//    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void deleteById(Long id) {
        Person person = findById(id);
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
