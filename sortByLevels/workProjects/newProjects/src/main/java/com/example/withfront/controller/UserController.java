package com.example.withfront.controller;

import com.example.withfront.model.DrRules;
import com.example.withfront.model.Role;
import com.example.withfront.model.User;
import com.example.withfront.repo.user.UserRepo;
import com.example.withfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping( "users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUser(@RequestParam(required=false,defaultValue="" ) String filter, Model model){

        List<User> data;
        if (filter==null||filter.isEmpty()){
            data = userRepo.findAll();
        }
        else{
            data = userRepo.getAllByUsername(filter);
        }
        model.addAttribute("users",data);
        return "users";
    }
    
    @GetMapping(path = {"users/edit", "users/edit/{id}"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) {

        model.addAttribute("role", Role.values());
        if (id.isPresent()) {
            Optional<User> data = userRepo.findById(id.get());
            model.addAttribute("users", data);

        } else {
            model.addAttribute("users", new User());
        }
        return "user-add";
    }

    @RequestMapping(path = {"users/add"},method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createOrUpdate(@ModelAttribute User users)  {
            Optional<User> user = userRepo.findUserByUsername(users.getUsername());
            if (user.isPresent()){
            User newUser=user.get();
            newUser.setFirstname(users.getFirstname());
            newUser.setUsername(users.getUsername());
            newUser.setEmail(users.getEmail());
            newUser.setLastname(users.getLastname());
            newUser.setRoles(users.getRoles());
            newUser.setActive(true);
            newUser.setPassword(passwordEncoder.encode(users.getPassword()));
            newUser.setRepeatPassword(passwordEncoder.encode(users.getRepeatPassword()));
            userRepo.save(newUser);
        } else {
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            users.setRepeatPassword(passwordEncoder.encode(users.getRepeatPassword()));
            users.setActive(true);
            userRepo.save(users);
        }
        return "redirect:/users";
    }

    @RequestMapping("users/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String postDelete(@PathVariable(value = "id") Long id, Model model){
        userRepo.deleteById(id);
        return "redirect:/users";
    }
    @RequestMapping("pages-profile")
    public String getProfile(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("user",user);
        return "pages-profile";
    }


}
