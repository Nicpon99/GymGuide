package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.final_project.entity.Training;
import pl.coderslab.final_project.entity.User;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findTrainingsByUserOrderByCreated(User user);


}
