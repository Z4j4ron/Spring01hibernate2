package pl.llasso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.llasso.entity.PersonDetails;
import pl.llasso.service.PersonDetailsService;

import javax.transaction.Transactional;

@RestController
@Transactional
public class PersonDetailsController {
    private PersonDetailsService personDetailsService;


    public PersonDetailsController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;

    }

    @GetMapping("/add/person/details/{firstName}/{lastName}/{streetNumber}/{street}/{city}")
    public void addPersonDetails(@PathVariable String firstName, @PathVariable String lastName, @PathVariable int streetNumber, @PathVariable String street, @PathVariable String city) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);

        personDetailsService.save(personDetails);
    }

    @GetMapping("/get/person/details/{id}")
    @ResponseBody
    public PersonDetails getPersonDetails(@PathVariable Long id) {
        return personDetailsService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personDetailsService.deleteById(id);
    }
    @GetMapping("/update/{id}/{firstName}/{lastName}/{streetNumber}/{street}/{city}")

    public void update(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable int streetNumber, @PathVariable String street, @PathVariable String city) {
        PersonDetails personDetails = personDetailsService.findById(id);
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);

        personDetailsService.update(personDetails);
    }
}
