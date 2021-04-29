package com.test.application.controller;

import com.test.application.model.credit.Credit;
import com.test.application.model.user.Customer;
import com.test.application.model.user.User;
import com.test.application.repo.CreditRepo;
import com.test.application.repo.CustomerRepo;
import com.test.application.repo.RateRepo;
import com.test.application.repo.TermRepo;
import com.test.application.service.IINValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private IINValidator iinValidator;

    @GetMapping("customer/new")
    public String get(@ModelAttribute("customer") Customer customer){
        return "customer/new";
    }

    @PostMapping("customer/new")
    public String create(@AuthenticationPrincipal User user,
            @ModelAttribute("customer") @Valid Customer customer,
            BindingResult bindingResult,Model model){
        if (!iinValidator.isValidIIN(customer.getIin())){
            model.addAttribute("iinError","неправильный ИИН");
            return "customer/new";
        }
        if (bindingResult.hasErrors())
            return "customer/new";
        customer.setUser(user);
//        customer.setCredit(new Credit());
        customerRepo.save(customer);
        return "redirect:/credit";
    }

}
