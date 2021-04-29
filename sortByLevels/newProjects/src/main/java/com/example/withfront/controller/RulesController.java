package com.example.withfront.controller;

import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.DrGateway;
import com.example.withfront.model.DrRules;
import com.example.withfront.repo.subscriber.DrGatewayRepo;
import com.example.withfront.repo.subscriber.DrRulesRepo;
import com.example.withfront.test.Ssh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("rules")
public class RulesController {
    @Autowired
    DrRulesRepo drRulesRepo;
    @Autowired
    DrGatewayRepo drGatewayRepo;
    @GetMapping
    public String greeting(@RequestParam(required=false,defaultValue="") String filter, Model model ) {
        List<DrRules> data;
        if (filter==null||filter.isEmpty()){
            data = drRulesRepo.findAll();
        }
        else{
            data = drRulesRepo.findAllByDescription(filter);
        }
        model.addAttribute("drRules",data);
        return "rules";
    }
    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
       List<DrGateway> drGateway= drGatewayRepo.findAll();
       model.addAttribute("gateways",drGateway);
        if (id.isPresent()) {
            DrRules data = drRulesRepo.findByRuleId(id.get());
            model.addAttribute("drRules", data);

        } else {
            model.addAttribute("drRules", new DrRules());
        }

        return "rules-add";
    }
    @RequestMapping(path = {"/add"},method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute DrRules drRules)  {
        Optional<DrRules> drRule = drRulesRepo.findById(drRules.getRuleId());
        if (drRule.isPresent()){
            DrRules newDrRules=drRule.get();
            newDrRules.setGroupId(drRules.getGroupId());
            newDrRules.setDescription(drRules.getDescription());
            newDrRules.setGwList(drRules.getGwList());
            newDrRules.setPrefix(drRules.getPrefix());
            newDrRules.setGwList(drRules.getGwList());
            newDrRules.setTimeRec(drRules.getPrefix());
            drRulesRepo.save(newDrRules);
        }else{
            drRulesRepo.save(drRules);
        }
        return "redirect:/rules";
    }
    @RequestMapping("/delete/{id}")
    public String postDelete(@PathVariable(value = "id")Integer id, Model model){
        drRulesRepo.deleteById(id);
        return "redirect:/rules";
    }
    @PostMapping
    public String activate(@RequestParam(required=false,defaultValue="") String filter, Model model){
        List<DrRules> data;
        if (filter==null||filter.isEmpty()){
            data = drRulesRepo.findAll();
        }
        else{
            data = drRulesRepo.findAllByDescription(filter);
        }
        model.addAttribute("drRules",data);
        List<String> reload = Ssh.reload("kamcmd drouting.reload");
        for (String s:reload) {
            System.out.println(s);
        }
        model.addAttribute("reload",reload);
        return "rules";
    }

}
