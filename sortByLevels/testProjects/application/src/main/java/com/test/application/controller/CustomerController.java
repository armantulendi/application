package com.test.application.controller;

import com.test.application.model.credit.Credit;
import com.test.application.model.user.Customer;
import com.test.application.model.user.Orders;
import com.test.application.model.user.User;
import com.test.application.repo.CustomerRepo;
import com.test.application.repo.OrderRepo;
import com.test.application.repo.RateRepo;
import com.test.application.repo.TermRepo;
import com.test.application.service.CheckCredit;
import com.test.application.service.IINValidator;
import com.test.application.service.ReadXMLFile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping
@SessionAttributes(types = {Customer.class,Credit.class})
public class CustomerController {
    private final CustomerRepo customerRepo;
    private final IINValidator iinValidator;
    private final RateRepo rateRepo;
    private final TermRepo termRepo;
    private final ReadXMLFile readXml;
    private final CheckCredit checkCredit;
    private final OrderRepo orderRepo;

    public CustomerController(CustomerRepo customerRepo, IINValidator iinValidator, RateRepo rateRepo, TermRepo termRepo, ReadXMLFile readXml, CheckCredit checkCredit, OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.iinValidator = iinValidator;
        this.rateRepo = rateRepo;
        this.termRepo = termRepo;
        this.readXml = readXml;
        this.checkCredit = checkCredit;
        this.orderRepo = orderRepo;
    }

    @GetMapping("customer/new")
    public String get(@ModelAttribute("customer") Customer customer){
        return "customer/new";
    }

    @PostMapping("customer/new")
    public String create(
            @AuthenticationPrincipal User user,
            @ModelAttribute("customer") @Valid Customer customer,
            BindingResult bindingResult,
            Model model){

        if (!iinValidator.isValidIIN(customer.getIin())){
            model.addAttribute("iinError","неправильный ИИН");
            return "customer/new";
        }
        if (bindingResult.hasErrors())
            return "customer/new";
        customer.setUser(user);
        customerRepo.save(customer);
        return "redirect:/credit";
    }
    @GetMapping("credit")
    public String getCredit(
            @ModelAttribute("credit") Credit credit,
                            Model model ){
        model.addAttribute("rates",rateRepo.findAll());
        model.addAttribute("terms",termRepo.findAll());
        model.addAttribute("sumToDollar",readXml.getCourseOfDollar());
        return "credit";
    }
    @PostMapping ("credit")
    public String postCredit(@AuthenticationPrincipal User user,
                             @RequestParam("everyPay") String everyPay,
                             @RequestParam("term") Integer term,
                             @ModelAttribute("credit") Credit credit,Customer customer,Model model){
        boolean status=checkCredit.checking(customer,everyPay);
        Orders order=new Orders();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        order.setDate(simpleDateFormat.format(new Date()));
        order.setStatus(status);
        order.setTerm(term);
        order.setUser(user);
        order.setSum(credit.getSum());
        order.setIin(customer.getIin());
        orderRepo.save(order);
        model.addAttribute("status",status );
        return "check";
    }

    @ModelAttribute(value = "customer")
    public Customer newCustomer(){
        return new Customer();
    }
    @ModelAttribute(value = "credit")
    public Credit newCredit(){
        return new Credit();
    }

}
