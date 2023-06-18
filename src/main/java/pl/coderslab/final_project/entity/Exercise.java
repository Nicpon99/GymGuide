package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
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
    private String description;
    private String link;
    private String muscles;
    private Integer popularity;
    @ManyToMany
    private List<MusclePart> musclePartList;
}
