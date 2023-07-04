package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.Training;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.repository.TrainingRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TrainingService {

    private TrainingRepository trainingRepository;

    public void save(Training training){
        trainingRepository.save(training);
    }

    public List<Training> findAll(){
        return trainingRepository.findAll();
    }

    public Optional<Training> findById(Long id){
        return trainingRepository.findById(id);
    }

    public void deleteById(Long id){
        trainingRepository.deleteById(id);
    }

    public List<Training> findByUser(User user){
        return trainingRepository.findTrainingsByUserOrderByCreated(user);
    }

}
