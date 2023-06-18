package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.final_project.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
