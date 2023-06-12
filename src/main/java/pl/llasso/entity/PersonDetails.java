package pl.llasso.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "personsDetails")
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer streetNumber;
    private String street;
    private String city;
    @OneToOne(mappedBy = "personDetails")
    private Person person;

}
