package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.final_project.entity.TrainingExercise;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {

}
