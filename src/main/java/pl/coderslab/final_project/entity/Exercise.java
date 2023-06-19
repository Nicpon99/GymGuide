package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@ToString
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    private String link;
    private String muscles;
    private Integer popularity = 0;
    @ManyToMany
    private List<MusclePart> muscleParts;
}
