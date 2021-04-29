package com.test.application.controller;

import com.test.application.model.user.Customer;
import com.test.application.model.user.User;
import com.test.application.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainControler {
    private final CustomerRepo customerRepo;

    public MainControler(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public String get(@AuthenticationPrincipal User user,
                      @RequestParam(required = false,defaultValue = "")
                      String filter, Model model){
        if (customerRepo.getByUserId(user.getId())!=null){
            List<Customer> customers;
            if (filter==null||filter.isEmpty())
                customers=customerRepo.findAll();
            else
                customers=customerRepo.findByIin(filter);
            model.addAttribute("customers",customers);
            return "customer/customers";
        }
        return "customer/new";
    }

}
