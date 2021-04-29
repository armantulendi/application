package com.project.data.controller;

import com.project.data.model.DrGateway;
import com.project.data.repo.DrGatewayRepo;
import com.project.data.repo.DrGroupsRepo;
import org.apache.catalina.connector.Response;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/gateway")
public class DrGatewayController {
    @Autowired
    DrGroupsRepo drGroupsRepo;
    @Autowired
    DrGatewayRepo drGatewayRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public String getGateway(Model model){
        Iterable<DrGateway> gateway = drGatewayRepo.findAll();
        model.addAttribute("gateway",gateway);
        return "forGateways";
    }
    @PostMapping("{id}")
    public String postDelete(@PathVariable Integer id, Model model){
        drGatewayRepo.deleteById(id);
        return "redirect:/gateway";
    }

    @PostMapping("/save")
    public String addSubscribe(@ModelAttribute("drGateway") @Valid DrGateway drGateway,
                               BindingResult bindingResult,
                               Model model)  {
        if (bindingResult.hasErrors())
            return "forGateways";
        drGatewayRepo.save(drGateway);
        return "redirect:/gateway";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id){
            drGatewayRepo.deleteById(id) ;
        return "redirect:/gateway";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("drGateway"    ) @Valid DrGateway drGateway,
                               BindingResult bindingResult,
                               Model model)  {
        if (bindingResult.hasErrors()){
            return "forGateways";
        }
        else {
        DrGateway drGateway1=drGatewayRepo.findByGwId(drGateway.getGwId());
        drGateway1.setDescription(drGateway.getDescription());
        drGateway1.setStrip(drGateway.getStrip());
        drGateway1.setType(drGateway.getType());
        drGateway1.setGwAddress(drGateway.getGwAddress());
        drGateway1.setPriPrefix(drGateway.getPriPrefix());
        drGatewayRepo.save(drGateway1);}
        return "redirect:/gateway";
    }

}
