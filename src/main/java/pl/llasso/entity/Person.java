package pl.llasso.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String login;
//    @Setter(AccessLevel.NONE)
    private String password;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_details_id")
    private PersonDetails personDetails;

}