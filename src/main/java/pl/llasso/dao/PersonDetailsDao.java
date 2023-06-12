package pl.llasso.dao;

import org.springframework.stereotype.Repository;
import pl.llasso.entity.Person;
import pl.llasso.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails findById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

//    public List<PersonDetails> findAll() {
//        return entityManager.createQuery("select p from PersonDetails p")
//                .getResultList();
//    }

    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public void deleteById(Long id) {
        PersonDetails personDetails = findById(id);
        entityManager.remove(entityManager.contains(personDetails) ? personDetails : entityManager.merge(personDetails));
    }
}
