package com.example.withfront.service;

import com.example.withfront.model.Role;
import com.example.withfront.model.User;
import com.example.withfront.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserService() {
    }

//    public boolean addUser(User user){
////        User userFromDb=userRepo.findByUsername(user.getUsername());
//        if (userFromDb!=null){
//            return false;
//        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepo.save(user);
//        return true;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void save(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

//    public void updateProfile(
//            User user,
//            String password,
//            String email,
//            String firstname,
//            String lastname,
//            String username,
//            String repeatPassword
//            ) {
//        String userEmail=user.getEmail();
////      Проверяет изменение старого и нового параметра email
//        boolean isEmailChanged= (email!=null && !email.equals(userEmail)
//                ||userEmail!=null && userEmail.equals(email));
//        if(isEmailChanged)
//            user.setEmail(email);
//        if (!StringUtils.isEmpty(password))
//            user.setPassword(passwordEncoder.encode(password));
//        if (repeatPassword!=null && !repeatPassword.equals(user.getPassword()))
//            user.setRepeatPassword(passwordEncoder.encode(repeatPassword));
//        if (firstname!=null && !firstname.equals(user.getFirstname()))
//            user.setFirstname(firstname);
//        if (lastname!=null && !lastname.equals(user.getLastname()))
//            user.setLastname(lastname);
//        if (username!=null && !username.equals(user.getUsername()))
//            user.setUsername(username);
//        userRepo.save(user);
//    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public List<User> getAllById(String username) {
        return userRepo.getAllByUsername(username);
    }
}
