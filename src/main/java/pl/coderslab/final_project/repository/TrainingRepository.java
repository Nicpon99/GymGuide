package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.final_project.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

}
