package pl.coderslab.final_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.final_project.service.MusclePartService;

@Controller
public class MusclePartController {

    private MusclePartService musclePartService;

    public MusclePartController(MusclePartService musclePartService) {
        this.musclePartService = musclePartService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("muscleParts", musclePartService.findAllSorted());
        return "homepage";
    }

}
