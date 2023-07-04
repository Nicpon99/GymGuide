package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trainings")
@Getter
@Setter
@ToString
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nazwa nie może być pusta")
    private String name;
    @NotEmpty(message = "Opis nie może być pusty")
    private String description;
    private LocalDateTime created;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Exercise> exercises;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

}
