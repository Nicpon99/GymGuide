package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.Exercise;
import pl.coderslab.final_project.entity.MusclePart;
import pl.coderslab.final_project.entity.Training;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.repository.ExerciseRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public void save(Exercise exercise){
        exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> findById(Long id){
        return exerciseRepository.findById(id);
    }

    public void deleteById(Long id){
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> findExercisesByMusclePart(MusclePart musclePart){
        return exerciseRepository.findExercisesByMusclePartsOrderByPopularityDesc(musclePart);
    }

    public void increasePopularity(Long id){
        exerciseRepository.increasePopularity(id);
    }

    public void decreasePopularity(Long id){
        exerciseRepository.decreasePopularity(id);
    }

    public List<Exercise> findExercisesByUser(User user){
        return exerciseRepository.findExercisesByUsersOrderByNameAsc(user);
    }

    public List<Exercise> findByMusclePartsAndUser(MusclePart musclePart, User user){
        return exerciseRepository.findExercisesByMusclePartsAndUsersOrderByName(musclePart, user);
    }

    public List<Exercise> findByTraining(Training training){
        return exerciseRepository.findExercisesByTrainingsOrderByName(training);
    }

}
