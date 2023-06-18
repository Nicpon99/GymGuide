package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trainings_exercises")
@Getter
@Setter
@ToString
public class TrainingExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long exercises_id;
    private Long trainings_id;
    private Integer series;

}
