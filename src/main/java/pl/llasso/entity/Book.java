package pl.llasso.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@ToString//(exclude = {"rating"})
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotBlank(message = "{title.not.empty.error}")
    @Size(min = 5, message = "{title.to.short.error}")
    private String title;
    @ToString.Exclude
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @NotNull
    @ManyToOne//(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    @ManyToMany//(fetch = FetchType.EAGER)
    @ToString.Exclude
    @NotEmpty
    private List<Author> authors = new ArrayList<>();
    @Min(1)
    private int pages;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Category category;

}