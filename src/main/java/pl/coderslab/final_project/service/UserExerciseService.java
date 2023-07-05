package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.UserExercise;
import pl.coderslab.final_project.repository.UserExerciseRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserExerciseService {

    private UserExerciseRepository userExerciseRepository;

    public void save(UserExercise userExercise){
        userExerciseRepository.save(userExercise);
    }

    public List<UserExercise> findAll(){
        return userExerciseRepository.findAll();
    }

    public Optional<UserExercise> findById(Long id){
        return userExerciseRepository.findById(id);
    }

    public void deleteById(Long id){
        userExerciseRepository.deleteById(id);
    }

    public UserExercise findByExerciseIdAndUserId(Long exerciseId, Long UserId){
        return userExerciseRepository.findByExerciseAndUser(exerciseId, UserId);
    }

    public Optional<UserExercise> findByExerciseId(Long exerciseId){
        return userExerciseRepository.findByExerciseId(exerciseId);
    }

}
