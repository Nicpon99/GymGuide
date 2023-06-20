package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.final_project.entity.MusclePart;

import java.util.List;

public interface MusclePartRepository extends JpaRepository<MusclePart, Long> {

    List<MusclePart> findMusclePartsByOrderByNameAsc();

}
