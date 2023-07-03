package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)

    @Size(min = 4, max = 25, message = "Wartość \"USERNAME\" musi zawierać od 4 do 25 znaków")
    private String username;

    @NotEmpty(message = "Wartość \"EMAIL\" nie może być pusta")
    @Email(message = "Nieprawidłowy format adresu e-mail")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).{6,}$", message = "Wartość \"PASSWORD\" musi zawierać przynajmniej jedną wielką literę, przynajmniej jedną cyfrę i składać się z co najmniej 6 znaków")
    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name ="role_id"))
    private Set<Role> roles;

    @ManyToMany
    private List<Exercise> exercises;

}
