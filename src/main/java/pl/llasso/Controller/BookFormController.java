package pl.llasso.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.llasso.entity.Author;
import pl.llasso.entity.Book;
import pl.llasso.entity.Category;
import pl.llasso.entity.Publisher;
import pl.llasso.service.AuthorService;
import pl.llasso.service.BookService;
import pl.llasso.service.CategoryService;
import pl.llasso.service.PublisherService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookFormController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;

    @GetMapping(path = "/book/form")
    String showAddBookForm(Model model){
        model.addAttribute("book", new Book());
        return  "book/add";
    }

    @PostMapping(path = "/book/form")
    String processAddBookForm(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "book/add";
        }
        bookService.save(book);
        return "redirect:/book/list";
    }
    @PostMapping(path = "/book/edit")
    String processEditBookForm(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/edit";
        }

        bookService.update(book);

        return "redirect:/book/list";
    }

        // wyswietlanie listy wszystkich ksiazek
        @GetMapping(path = "/book/list")
        String showBookList(Model model) {

            List<Book> books = bookService.findAll();
            model.addAttribute("books", books);

            return "book/list";
        }
        @ModelAttribute("authors")
        Collection<Author> authors() {
            return authorService.findAll();
    }

        // umieszczenie w modelu pod kluczem 'publishers' kolekcji obiektow Publisher
        @ModelAttribute("publishers")
        Collection<Publisher> findAllPublishers() {
            return publisherService.findAll();
        }
        @ModelAttribute("categories")
        Collection<Category> categories() {
        return categoryService.findAll();
    }
        // np. http://localhost:8080/book/search?title=Java+techniki+programowania
        @GetMapping(path = "/book/search", params = "title")
        String findByTile(@RequestParam String title, Model model) {

        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("books", books);

        return "book/list";

    }
    // np. http://localhost:8080/book/search?id=2
    @GetMapping(path = "/book/search", params = "id")
    String findByCategory(Category category, Model model) {

        List<Book> books = bookService.findByCategory(category);
        model.addAttribute("books", books);

        return "book/list";
    }

    // np. http://localhost:8080/book/search?categoryId=2
    @GetMapping(path = "/book/search", params = "categoryId")
    String findByCategoryId(@RequestParam Long categoryId, Model model) {

        List<Book> books = bookService.findByCategoryId(categoryId);
        model.addAttribute("books", books);

        return "book/list";
    }
    //http://localhost:8080/book/search
    @GetMapping(path = "/book/search/category")
    String findFirstByCategoryOrderByTitle(Category category, Model model){
        Optional<Book> book = bookService.findFirstByCategoryOrderByTitle(category);
        List<Book> books = book.map(Collections::singletonList).orElse(Collections.emptyList());

        model.addAttribute("books", books);

        return "book/list";
    }


}
