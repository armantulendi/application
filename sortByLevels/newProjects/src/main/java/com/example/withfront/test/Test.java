//package com.example.withfront.test;
//
//import com.example.withfront.model.User;
//import com.example.withfront.repo.user.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("users")
//public class Test {
//    @Autowired
//    UserRepo userRepo;
//    @PostMapping("add")
//    @Transactional("userTransactionManager")
//    public String addUser( User users, Model model){
//        User user=new User();
//        model.addAttribute("newUser",user);
//        model.addAttribute("user",users);
//        return "";
//    }
//}
