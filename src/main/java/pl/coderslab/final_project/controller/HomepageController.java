package pl.coderslab.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.final_project.service.MusclePartService;

@Controller
public class HomepageController {

    private MusclePartService musclePartService;

    public HomepageController(MusclePartService musclePartService) {
        this.musclePartService = musclePartService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("muscleParts", musclePartService.findAllSorted());
        return "homepage";
    }

    @GetMapping("/info")
    public String appInfo(){
        return "app-info";
    }

}
