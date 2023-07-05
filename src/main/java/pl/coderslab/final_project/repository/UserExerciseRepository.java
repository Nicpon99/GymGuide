package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.final_project.entity.UserExercise;

import java.util.Optional;

@Repository
public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {

    @Query(value = "SELECT * FROM users_exercises WHERE exercises_id = ?1 AND users_id = ?2", nativeQuery = true)
    UserExercise findByExerciseAndUser(Long exercisesId, Long usersId);


    @Query(value = "SELECT * FROM users_exercises WHERE exercises_id = ?1", nativeQuery = true)
    Optional<UserExercise> findByExerciseId(Long exerciseId);
}
