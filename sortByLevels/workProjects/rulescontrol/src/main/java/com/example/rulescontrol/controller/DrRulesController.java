package com.example.rulescontrol.controller;


import com.example.rulescontrol.model.DrGateway;
import com.example.rulescontrol.model.DrRules;
import com.example.rulescontrol.repo.DrGatewayRepo;
import com.example.rulescontrol.repo.DrRulesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rules")
public class DrRulesController {
    @Autowired
    DrRulesRepo drRulesRepo;
    @Autowired
    DrGatewayRepo drGatewayRepo;
    List<String> result=new ArrayList<>(2);
    @GetMapping
    public String getRules(  Model model){
        List<DrRules> rules= drRulesRepo.findAll();
        List<DrGateway> gateways= drGatewayRepo.findAll();

        model.addAttribute("rules",rules);
        model.addAttribute("gateways",gateways);

        return "forRules";
    }

    @PostMapping("/save")
    public String addSubscribe(@ModelAttribute @Valid DrRules drRules,
                               BindingResult bindingResult,
                               Model model)  {
//        if (bindingResult.hasErrors())
//            model.addAttribute()
//            return "forRules";
        if (drRules.getTimeRec()==null)
            drRules.setTimeRec("");
        drRulesRepo.save(drRules);
        return "redirect:/rules";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id){
        drRulesRepo.deleteById(id) ;
        return "redirect:/rules";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Valid DrRules drRules,
                         BindingResult bindingResult,
                         Model model)  {
        if (drRules.getTimeRec()==null)
            drRules.setTimeRec("");
        DrRules dr= drRulesRepo.findByRuleId(drRules.getRuleId());
        dr.setDescription(drRules.getDescription());
        dr.setDescription(drRules.getDescription());
        dr.setPrefix(drRules.getPrefix());
        dr.setGroupId(drRules.getGroupId());
        dr.setRouteId(drRules.getRouteId());
        dr.setGwList(drRules.getGwList());
        dr.setPriority(drRules.getPriority());
        drRulesRepo.save(dr);
        return "redirect:/rules";
    }
    @PostMapping("/activate")
    public String reload(Model model) throws Exception {

        List<DrRules> rules= drRulesRepo.findAll();
        List<DrGateway> gateways= drGatewayRepo.findAll();

        model.addAttribute("rules",rules);
        model.addAttribute("gateways",gateways);
        result= Ssh.reload("kamcmd drouting.reload ");
        model.addAttribute("resultCommand",result);
        return "forRules";
    }
}
