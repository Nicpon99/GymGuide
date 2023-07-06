package pl.coderslab.final_project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.final_project.entity.*;
import pl.coderslab.final_project.service.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class TrainingController {

    private TrainingService trainingService;
    private TrainingExerciseService trainingExerciseService;
    private ExerciseService exerciseService;
    private UserService userService;
    private MusclePartService musclePartService;

    @GetMapping("/training/create")
    public String createTraining(Model model){
        model.addAttribute("training", new Training());
        return "create-training";
    }

    @PostMapping("/training/create")
    public String saveTraining(@Valid Training training, BindingResult result, Principal principal){
        if (result.hasErrors()){
            return "create-training";
        }
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            training.setUser(user);
            trainingService.save(training);
            return "redirect:/training/create/" + training.getId() + "/muscleParts";
        } else {
            return "error";
        }
    }

    @GetMapping("/training/create/{trainingId}/muscleParts")
    public String selectMuscleParts(@PathVariable("trainingId") Long trainingId, Model model){
        model.addAttribute("trainingId", trainingId);
        model.addAttribute("muscleParts", musclePartService.findAll());
        return "select-muscle-parts";
    }

    @GetMapping("/training/create/{trainingId}/muscleParts/added")
    public String selectExercisesForTraining(@PathVariable("trainingId") Long trainingId, @RequestParam("muscles") Long[] muscles, Model model, Principal principal) {
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null) {
            LinkedHashMap<MusclePart, List<Exercise>> exercises = new LinkedHashMap<>();
            for (Long muscleId : muscles) {
                MusclePart musclePart = musclePartService.findById(muscleId).orElse(null);
                if (musclePart != null){
                    exercises.put(musclePart, exerciseService.findByMusclePartsAndUser(musclePart, user));
                }
            }
            model.addAttribute("trainingId", trainingId);
            model.addAttribute("exercises", exercises);
            return "select-exercises";
        } else {
            return "error";
        }
    }

    @GetMapping("/training/create/{trainingId}/muscleParts/added/exercises")
    public String selectSeriesAndSequenceForTraining(@PathVariable("trainingId") Long trainingId,
                                                  @RequestParam("exercisesIdsForTraining") Long[] exercisesIdsForTraining, Model model){
        LinkedHashMap<TrainingExercise, String> trainingWithExercises = new LinkedHashMap<>();
        for (Long exerciseId : exercisesIdsForTraining) {
            TrainingExercise trainingExercise = new TrainingExercise();
            trainingExercise.setTrainings_id(trainingId);
            trainingExercise.setExercises_id(exerciseId);
            trainingExerciseService.save(trainingExercise);
            Exercise exercise = exerciseService.findById(exerciseId).orElse(null);
            if (exercise != null){
                trainingWithExercises.put(trainingExercise, exercise.getName());
            } else {
                return "error";
            }
        }


        model.addAttribute("trainingWithExercises", trainingWithExercises);
        model.addAttribute("mapLength", trainingWithExercises.size());
        return "select-series-and-sequence";
    }

    @GetMapping("/training/save")
    public String saveTraining(@RequestParam("trainingExerciseIds") Long[] trainingExerciseIds,
                               @RequestParam("series") String[] series, @RequestParam("sequence") String[] sequence){


        for (int i = 0; i < trainingExerciseIds.length; i++){
            trainingExerciseService.saveSeriesAndSequence(Integer.parseInt(series[i]), Integer.parseInt(sequence[i]), trainingExerciseIds[i]);
        }
        return "redirect:/user/profile";
    }

    @GetMapping("/training/description/{trainingId}")
    public String getTrainingDescription(@PathVariable("trainingId") Long trainingId, Model model){
        Training training = trainingService.findById(trainingId).orElse(null);
        List<TrainingExercise> trainingExercises = trainingExerciseService.findByTrainingId(trainingId);
        LinkedHashMap<TrainingExercise, LinkedHashMap<Exercise, List<String>>> trainingWithExercises = new LinkedHashMap<>();
        for (TrainingExercise trainingExercise : trainingExercises) {
            Exercise exercise = exerciseService.findById(trainingExercise.getExercises_id()).orElse(null);
            String[] muscles = exercise.getMuscles().split(", ");
            LinkedHashMap<Exercise, List<String>> exercisesMap = new LinkedHashMap<>();
            exercisesMap.put(exercise, Arrays.asList(muscles));
            trainingWithExercises.put(trainingExercise, exercisesMap);
        }
        model.addAttribute("training", training);
        model.addAttribute("trainingWithExercises", trainingWithExercises);
        return "training-description";
    }

}
