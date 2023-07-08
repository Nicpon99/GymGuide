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
    public String getExercisesByMuscle(@PathVariable("id") Long id, Model model, Principal principal){
        MusclePart musclePart = musclePartService.findById(id).orElse(null);
        if (musclePart != null){
            List<Exercise> exercises = exerciseService.findExercisesByMusclePart(musclePart);

            LinkedHashMap<Exercise, LinkedHashMap<List<String>, String>> exerciseMap = new LinkedHashMap<>();

            for (Exercise exercise : exercises) {
                LinkedHashMap<List<String>, String> musclesWithLikes = new LinkedHashMap<>();
                String muscles = exercise.getMuscles();
                String[] musclesArray = muscles.split(", ");

                User user = userService.findByUserName(principal.getName()).orElse(null);
                String like = "";
                UserExercise userExercise = userExerciseService.findByExerciseIdAndUserId(exercise.getId(), user.getId());
                if (userExercise == null){
                    like = "false";
                } else {
                    like = "true";
                }

                musclesWithLikes.put(Arrays.asList(musclesArray), like);

                exerciseMap.put(exercise, musclesWithLikes);
            }

            model.addAttribute("musclePart", musclePart);
            model.addAttribute("exercises", exerciseMap);
            model.addAttribute("muscleId", id);
            return "exercises";
        } else {
            return "error";
        }
    }

    @GetMapping("/exercises/description/{muscleId}/{exerciseId}")
    public String getExerciseDescription(@PathVariable("exerciseId") Long exerciseId, @PathVariable("muscleId") Long muscleId, Model model, Principal principal){
        Exercise exercise =  exerciseService.findById(exerciseId).orElse(null);
        if (exercise != null){
            String muscles = exercise.getMuscles();
            List<String> musclesList = List.of(muscles.split(", "));
            model.addAttribute("muscles", musclesList);

            String description = exercise.getDescription();
            List<String> descriptionList = List.of(description.split("\\. "));

            User user = userService.findByUserName(principal.getName()).orElse(null);
            String like = "";
            UserExercise userExercise = userExerciseService.findByExerciseIdAndUserId(exercise.getId(), user.getId());
            if (userExercise == null){
                like = "false";
            } else {
                like = "true";
            }

            MusclePart musclePart = musclePartService.findById(muscleId).orElse(null);
            if (musclePart != null){
                model.addAttribute("musclePart", musclePart);
            } else {
                return "error";
            }

            model.addAttribute("description", descriptionList);

            model.addAttribute("exercise", exercise);

            model.addAttribute("like", like);



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

    @GetMapping("exercises/description/like/{muscleId}/{exerciseId}")
    public String likeExerciseFromDescription(@PathVariable("exerciseId") Long exerciseId, @PathVariable("muscleId") Long muscleId, Principal principal){
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            if (userExerciseService.findByExerciseIdAndUserId(exerciseId, user.getId()) == null){
                UserExercise userExercise = new UserExercise();
                userExercise.setExercises_id(exerciseId);
                userExercise.setUsers_id(user.getId());
                userExerciseService.save(userExercise);
                exerciseService.increasePopularity(exerciseId);
                return "redirect:/exercises/description/" + muscleId + "/" + exerciseId;
            } else {
                userExerciseService.deleteById(userExerciseService.findByExerciseIdAndUserId(exerciseId, user.getId()).getId());
                exerciseService.decreasePopularity(exerciseId);
                return "redirect:/exercises/description/" + muscleId + "/" + exerciseId;
            }

        } else {
            return "error";
        }
    }
}
