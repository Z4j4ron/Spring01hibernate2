package pl.llasso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.llasso.entity.Person;
import pl.llasso.service.PersonDetailsService;
import pl.llasso.service.PersonService;

import javax.transaction.Transactional;

@RestController
@Transactional
public class PersonController {
    private final PersonService personService;
    private final PersonDetailsService personDetailsService;

    public PersonController(PersonService personService, PersonDetailsService personDetailsService) {
        this.personService = personService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/get/person/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping("/add/person/{login}/{password}/{email}/{id}")

    public void addPerson(@PathVariable String login, @PathVariable String password, @PathVariable String email, @PathVariable Long id) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        person.setPersonDetails(personDetailsService.findById(id));

        personService.save(person);

    }

    @GetMapping("/delete/person/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @GetMapping("/update/person/{id}/{login}/{password}/{email}")
    public void updatePerson(@PathVariable Long id, @PathVariable String login, @PathVariable String password, @PathVariable String email) {
        Person person = personService.findById(id);
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personService.update(person);
    }

    @GetMapping(path = "/form")
    String showAddForm(){
        return "person/form";
    }
    @PostMapping(path = "/form")
    @ResponseBody
    String processAddForm(Person person){
        personService.save(person);
        return person.toString();
    }
//    @PostMapping(path = "/form")
//    @ResponseBody
//    String processAddForm(@RequestParam String login, @RequestParam String password, @RequestParam String email){
//
//        Person person = new Person();
//
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//
//        return person.toString();
//    }
}
