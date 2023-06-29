package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.final_project.entity.Exercise;
import pl.coderslab.final_project.entity.MusclePart;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findExercisesByMusclePartsOrderByPopularityDesc(MusclePart musclePart);

}
