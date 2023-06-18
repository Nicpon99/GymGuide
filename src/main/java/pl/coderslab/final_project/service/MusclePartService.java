package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.MusclePart;
import pl.coderslab.final_project.repository.MusclePartRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class MusclePartService {

    private MusclePartRepository musclePartRepository;

    public void save(MusclePart musclePart){
        musclePartRepository.save(musclePart);
    }

    public List<MusclePart> findAll(){
       return musclePartRepository.findAll();
    }

    public Optional<MusclePart> findById(Long id){
        return musclePartRepository.findById(id);
    }

    public void deleteById(Long id){
        musclePartRepository.deleteById(id);
    }

}
