package pl.coderslab.final_project.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.service.UserService;


@Controller
@SessionAttributes("userId")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }



    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }


}
