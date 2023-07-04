package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.TrainingExercise;
import pl.coderslab.final_project.repository.TrainingExerciseRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TrainingExerciseService {

    private TrainingExerciseRepository trainingExerciseRepository;

    public void save(TrainingExercise trainingExercise){
        trainingExerciseRepository.save(trainingExercise);
    }

    public List<TrainingExercise> findAll(){
        return trainingExerciseRepository.findAll();
    }

    public Optional<TrainingExercise> findById(Long id){
        return trainingExerciseRepository.findById(id);
    }

    public void deleteById(Long id){
        trainingExerciseRepository.deleteById(id);
    }

    public void saveSeriesAndSequence(Integer series, Integer sequence, Long id){
        trainingExerciseRepository.saveSeriesAndSequence(series, sequence, id);
    }

    public List<TrainingExercise> findByTrainingId(Long id){
        return trainingExerciseRepository.findByTrainingId(id);
    }

}
