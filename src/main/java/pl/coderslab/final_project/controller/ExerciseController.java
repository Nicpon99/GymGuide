package pl.coderslab.final_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.final_project.entity.Exercise;
import pl.coderslab.final_project.entity.MusclePart;
import pl.coderslab.final_project.service.ExerciseService;
import pl.coderslab.final_project.service.MusclePartService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ExerciseController {

    private ExerciseService exerciseService;

    private MusclePartService musclePartService;

    @GetMapping("/exercises/{id}")
    public String getExercisesByMuscle(@PathVariable("id") Long id, Model model){
        MusclePart musclePart = musclePartService.findById(id).orElse(null);
        if (musclePart != null){
            List<Exercise> exercises = exerciseService.findExercisesByMusclePart(musclePart);

            Map<String, List<String>> exerciseMap = new HashMap<>();

            for (Exercise exercise : exercises) {
                String muscles = exercise.getMuscles();
                String[] musclesArray = muscles.split(", ");
                exerciseMap.put(exercise.getName(), Arrays.asList(musclesArray));
            }

            model.addAttribute("musclePart", musclePart);
            model.addAttribute("exercises", exerciseMap);
            return "exercises";
        } else {
            return "redirect:/";
        }
    }
}
