package com.example.sweater.controller;

import com.example.sweater.domain.other.Role;
import com.example.sweater.domain.other.User;
import com.example.sweater.repos.UserRepo;
import com.example.sweater.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }
//User GET
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

//    получение списка пользователей
    @GetMapping("{user}")
    public String userEditGet(@PathVariable(value = "user") User user, Model model) {
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    //редактирование пользователей
    @PostMapping("{user}")
    public String userEditPost(@RequestParam Map<String, String> form,
                               @PathVariable User user,
                               Model model) {
        userService.save(user,form);
        return "redirect:/user/";
    }
//   получение профиля текущего пользователя
    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("firstname",user.getFirstname());
        model.addAttribute("lastname",user.getLastname());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("repeatPassword",user.getRepeatPassword());
        model.addAttribute("email",user.getEmail());
        return "profile";
    }
    //редактирование профиля
    @PostMapping("/profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            Model model) {
        userService.updateProfile(
                user,user.getPassword(),user.getEmail(),
                user.getFirstname(),user.getLastname(),
                user.getUsername(),user.getRepeatPassword());
        model.addAttribute("success","изменено");
        return "redirect:/user/profile";
    }

//  удаление пользователей из списка
    @GetMapping("{id}/remove")
    public String getDeletePage(@PathVariable(value = "id") Long id,Model model) {
        return "redirect:/user";
    }

    @PostMapping("{id}/remove")
    public String postDeletePage(@PathVariable(value = "id") Long id,Model model) {
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("/roles")
    public String getRoles(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("users",userRepo.findAll());
        return "userEdit";
    }
}
