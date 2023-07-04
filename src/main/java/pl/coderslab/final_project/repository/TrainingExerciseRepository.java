package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.TrainingExercise;

import java.util.List;

@Repository
public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE trainings_exercises SET series = ?1, sequence = ?2 WHERE id = ?3", nativeQuery = true)
    void saveSeriesAndSequence(Integer series, Integer sequence, Long id);

    @Query(value = "SELECT * FROM trainings_exercises WHERE trainings_id = ?1 ORDER BY sequence", nativeQuery = true)
    List<TrainingExercise> findByTrainingId(Long id);
}
