package pl.llasso.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.llasso.entity.Book;
import pl.llasso.entity.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor

public class ValidationController {

    private final Validator validator;

    @RequestMapping("/validate")
    String validateTest() {
        Book p2 = new Book();
        p2.setTitle("ala");
        Set<ConstraintViolation<Book>> violations = validator.validate(p2);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                log.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
            return "Error";
        } else {
            return "validateResult";
            // save object
        }
    }

}
