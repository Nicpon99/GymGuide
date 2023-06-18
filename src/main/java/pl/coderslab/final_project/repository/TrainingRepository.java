package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.final_project.entity.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
