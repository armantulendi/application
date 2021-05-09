package com.test.application.controller;

import com.test.application.model.user.Customer;
import com.test.application.model.user.Orders;
import com.test.application.model.user.User;
import com.test.application.repo.OrderRepo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final OrderRepo orderRepo;

    public MainController(  OrderRepo orderRepo) {

        this.orderRepo = orderRepo;
    }

    @GetMapping
    public String get(@AuthenticationPrincipal User user,
                      @RequestParam(required = false,defaultValue = "")
                      String filter, Model model){
        if (orderRepo.getByUserId(user.getId()).size()!=0){
            List<Orders> orders;

            if (filter==null||filter.isEmpty())
                orders= orderRepo.findAll();
            else
                orders= orderRepo.findByIin(filter);
            model.addAttribute("orders",orders);
            return "customer/customers";
        }
        else
            return "redirect:/customer/new";
    }


}
