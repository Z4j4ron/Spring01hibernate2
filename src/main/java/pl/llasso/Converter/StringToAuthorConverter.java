package pl.llasso.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.llasso.entity.Author;
import pl.llasso.service.AuthorService;



public class StringToAuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String id) {

        long authorId = Long.parseLong(id);
        return authorService.findById(authorId);
    }
}
