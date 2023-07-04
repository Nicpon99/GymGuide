package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.Exercise;
import pl.coderslab.final_project.entity.MusclePart;
import pl.coderslab.final_project.entity.Training;
import pl.coderslab.final_project.entity.User;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findExercisesByMusclePartsOrderByPopularityDesc(MusclePart musclePart);

    @Modifying
    @Transactional
    @Query(value = "UPDATE exercises SET popularity = popularity + 1 WHERE id = ?1", nativeQuery = true)
    void increasePopularity(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE exercises SET popularity = popularity - 1 WHERE id = ?1", nativeQuery = true)
    void decreasePopularity(Long id);

    List<Exercise> findExercisesByUsersOrderByNameAsc(User user);

    List<Exercise> findExercisesByMusclePartsAndUsersOrderByName(MusclePart musclePart, User user);

    List<Exercise> findExercisesByTrainingsOrderByName(Training training);

}
