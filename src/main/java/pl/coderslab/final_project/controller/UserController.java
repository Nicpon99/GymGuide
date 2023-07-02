package pl.coderslab.final_project.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.service.UserService;

import java.security.Principal;
import java.util.Collection;
import java.util.concurrent.RecursiveTask;


@Controller
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
        return "redirect:/login";
    }

    @GetMapping("/user/profile")
    public String getUserAccount(Model model, Principal principal){
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            return "profile";
        }
        return "error";
    }

    @GetMapping("/user/data")
    public String getUserData(Model model, Principal principal) {
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-data";
        } else {
            return "error";
        }
    }

    @GetMapping("user/edit")
    public String editUser(Model model, Principal principal) {
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-edit";
        } else {
            return "error";
        }
    }

    @PostMapping("/user/edit")
    public String updateUser(@Valid User user,  BindingResult result){
        if (result.hasErrors()){
            return "user-edit";
        }
        userService.editUser(user);
        User u = userService.findByUserName(user.getUsername()).orElse(null);
        if (u != null){
            Collection<SimpleGrantedAuthority> nowAuthorities =
                    (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getAuthorities();
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword(), nowAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/user/data";
        } else {
            return "error";
        }
    }

    @GetMapping("/user/edit/password")
    public String editPassword(Model model, Principal principal){
        User user = userService.findByUserName(principal.getName()).orElse(null);
        if (user != null){
            user.setPassword("");
            model.addAttribute("user", user);
            return "user-edit-password";
        } else {
            return "error";
        }
    }

    @PostMapping("/user/edit/password")
    public String updatePassword(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-edit-password";
        }
        userService.editPassword(user);
        return "redirect:/user/profile";
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
