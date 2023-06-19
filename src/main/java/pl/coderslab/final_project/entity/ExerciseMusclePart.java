package pl.coderslab.final_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "exercises_muscle_parts")
@Getter
@Setter
@ToString
public class ExerciseMusclePart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long exercises_id;
    private Long muscleParts_id;

}
