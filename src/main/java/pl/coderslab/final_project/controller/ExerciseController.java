package pl.coderslab.final_project.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.final_project.entity.Exercise;
import pl.coderslab.final_project.entity.MusclePart;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.entity.UserExercise;
import pl.coderslab.final_project.service.ExerciseService;
import pl.coderslab.final_project.service.MusclePartService;
import pl.coderslab.final_project.service.UserExerciseService;
import pl.coderslab.final_project.service.UserService;

import java.security.Principal;
import java.util.*;


@Controller
@AllArgsConstructor
public class ExerciseController {

    private ExerciseService exerciseService;

    private UserService userService;

    private MusclePartService musclePartService;

    private UserExerciseService userExerciseService;

    @GetMapping("/exercises/{id}")
    public String getExercisesByMuscle(@PathVariable("id") Long id, Model model){
        MusclePart musclePart = musclePartService.findById(id).orElse(null);
        if (musclePart != null){
            List<Exercise> exercises = exerciseService.findExercisesByMusclePart(musclePart);

            LinkedHashMap<Exercise, List<String>> exerciseMap = new LinkedHashMap<>();

            for (Exercise exercise : exercises) {
                String muscles = exercise.getMuscles();
                String[] musclesArray = muscles.split(", ");
                exerciseMap.put(exercise, Arrays.asList(musclesArray));
            }

            model.addAttribute("musclePart", musclePart);
            model.addAttribute("exercises", exerciseMap);
            model.addAttribute("muscleId", id);
            return "exercises";
        } else {
            return "error";
        }
    }

    @GetMapping("/exercises/description/{id}")
    public String getExerciseDescription(@PathVariable("id") Long id, Model model){
        Exercise exercise =  exerciseService.findById(id).orElse(null);
        if (exercise != null){
            String muscles = exercise.getMuscles();
            List<String> musclesList = List.of(muscles.split(", "));
            model.addAttribute("muscles", musclesList);

            String description = exercise.getDescription();
            List<String> descriptionList = List.of(description.split("\\. "));
            model.addAttribute("description", descriptionList);

            model.addAttribute("exercise", exercise);

            return "description";
        } else {
            return "error";
        }
    }

    @GetMapping("/exercises/like/{muscleId}/{id}")
    public String likeExercise(@PathVariable("id") Long id,@PathVariable("muscleId") Long muscleId, Principal principal){
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            if (userExerciseService.findByExerciseIdAndUserId(id, user.getId()) == null){
                UserExercise userExercise = new UserExercise();
                userExercise.setExercises_id(id);
                userExercise.setUsers_id(user.getId());
                userExerciseService.save(userExercise);
                exerciseService.increasePopularity(id);
                return "redirect:/exercises/" + muscleId;
            } else {
                userExerciseService.deleteById(userExerciseService.findByExerciseIdAndUserId(id, user.getId()).getId());
                exerciseService.decreasePopularity(id);
                return "redirect:/exercises/" + muscleId;
            }

        } else {
            return "error";
        }
    }

    @GetMapping("exercises/description/like/{id}")
    public String likeExerciseFromDescription(@PathVariable("id") Long id, Principal principal){
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            if (userExerciseService.findByExerciseIdAndUserId(id, user.getId()) == null){
                UserExercise userExercise = new UserExercise();
                userExercise.setExercises_id(id);
                userExercise.setUsers_id(user.getId());
                userExerciseService.save(userExercise);
                exerciseService.increasePopularity(id);
                return "redirect:/exercises/description/" + id;
            } else {
                userExerciseService.deleteById(userExerciseService.findByExerciseIdAndUserId(id, user.getId()).getId());
                exerciseService.decreasePopularity(id);
                return "redirect:/exercises/description/" + id;
            }

        } else {
            return "error";
        }
    }
}
