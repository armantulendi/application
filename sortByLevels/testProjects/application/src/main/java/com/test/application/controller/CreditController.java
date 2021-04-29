package com.test.application.controller;

import com.test.application.model.credit.Credit;
import com.test.application.repo.CreditRepo;
import com.test.application.repo.RateRepo;
import com.test.application.repo.TermRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
public class CreditController {
    @Autowired
    private CreditRepo creditRepo;
    @Autowired
    private RateRepo rateRepo;
    @Autowired
    private TermRepo termRepo;
    @GetMapping("credit")
    public String getCredit(@ModelAttribute("credit") Credit credit, Model model ){
        model.addAttribute("rates",rateRepo.findAll());
        model.addAttribute("terms",termRepo.findAll());
        return "credit";
    }

    @PostMapping("credit")
    public String credit(
            @ModelAttribute("credit") @Valid Credit credit,
            BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "credit";
        creditRepo.save(credit);
        return "redirect:/customer/";
    }
}
