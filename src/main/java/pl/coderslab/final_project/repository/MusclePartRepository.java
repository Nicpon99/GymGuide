package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.final_project.entity.MusclePart;

import java.util.List;

@Repository
public interface MusclePartRepository extends JpaRepository<MusclePart, Long> {

    List<MusclePart> findMusclePartsByOrderByNameAsc();

}
