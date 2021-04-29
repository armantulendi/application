package com.example.sweater.controller;

import com.example.sweater.domain.other.User;
import com.example.sweater.repos.UserRepo;
import com.example.sweater.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserRepo userRepo;
    private final UserService userService;

    public RegistrationController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    //получение формы регистрации
    @GetMapping
    public String registration() {
        return "registration";
    }


    //добавление пользователя
    @PostMapping
    public String addUser(@Valid User user, BindingResult bindingResult,Model model) {
        if (user.getPassword()!=null&&!user.getPassword().equals(user.getRepeatPassword())){
            model.addAttribute("passwordError","Пароли не совпадают");
        }
        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "Пользователь существует");
            return "registration";
        }

        userRepo.save(user);
        return "redirect:/user";
    }
}
