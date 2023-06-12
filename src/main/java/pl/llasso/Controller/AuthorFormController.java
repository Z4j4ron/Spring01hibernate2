package pl.llasso.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.llasso.entity.Author;
import pl.llasso.entity.Book;
import pl.llasso.service.AuthorService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
class AuthorFormController {

    private final AuthorService authorService;

    @GetMapping(path = "/author/add")
    String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }
    // create author
    @PostMapping(path = "/author/add")
    String processAddAuthorForm(@Valid Author author, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "author/add";
        }

        authorService.save(author);

        return "redirect:/author/list";
    }

    @GetMapping(path = "/author/edit")
    String showEditAuthorForm(@RequestParam Long id, Model model) {

        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/edit";
    }
    // create author
    @PostMapping(path = "/author/edit")
    String processEditAuthorForm(@Valid Author author, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "author/edit";
        }

        authorService.update(author);

        return "redirect:/author/list";
    }

    @GetMapping(path = "/author/remove")
    String processRemoveAuthor(@RequestParam Long id) {

        authorService.deleteById(id);

        return "redirect:/author/list";
    }

    @GetMapping(path = "/author/list")
    String showAllAuthors(Model model) {

        List<Author> authors = authorService.findAll();

        model.addAttribute("authors", authors);

        return "author/list";
    }
}
