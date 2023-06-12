package pl.llasso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.llasso.entity.Person;
import pl.llasso.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping(path="/student/form")
    String showAddForm(Model model){
        model.addAttribute("student", new Student());
        return "student/form";
    }
    @PostMapping(path = "/student/form")
    @ResponseBody
    String processAddForm(Student student){

        return student.toString();
    }

    @ModelAttribute
    public List<String> countries(){
        return Arrays.asList("Poland","Germany", "France", "Russia", "Denmark");
    }
}
