package com.example.withfront.controller;

import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.DrGroups;
import com.example.withfront.model.DrRules;
import com.example.withfront.repo.subscriber.DrGatewayRepo;
import com.example.withfront.repo.subscriber.DrGroupsRepo;
import com.example.withfront.repo.subscriber.DrRulesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("groups")
public class GroupsController {
    @Autowired
    private DrGroupsRepo drGroupsRepo;
    @Autowired
    private DrRulesRepo drRulesRepo;
    @GetMapping
    public String greeting(@RequestParam(required=false,value = "username") String username, Model model ) {
        if (username==null||username.isEmpty()){
             List<DrGroups> data = drGroupsRepo.findAll();
            model.addAttribute("drGroups",data);
        }
        else{
            List<DrGroups> allByUserName= drGroupsRepo.findAllByUserName(username);
            model.addAttribute("drGroups",allByUserName);
        }
        return "groups-control";
    }
    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
        List<DrRules> drRules= drRulesRepo.findAll();
        model.addAttribute("rules",drRules);
        if (id.isPresent()) {
            DrGroups data = drGroupsRepo.findByIdGroup(id.get());
            model.addAttribute("drGroups", data);
        } else {
            model.addAttribute("drGroups", new DrGroups());
        }
        return "groups-control-add";
    }
    @RequestMapping(path = {"/add"},method = RequestMethod.POST)
    public String createOrUpdate(@ModelAttribute DrGroups drGroups)  {
        Optional<DrGroups> drGroup = drGroupsRepo.findById(drGroups.getIdGroup());
        if (drGroup.isPresent()){
            DrGroups newDrGroups=drGroup.get();
            newDrGroups.setDomain(drGroups.getDomain());
            newDrGroups.setDescription(drGroups.getDescription());
            newDrGroups.setUserName(drGroups.getUserName());
            newDrGroups.setDrRules(drGroups.getDrRules());
            drGroupsRepo.save(newDrGroups);
        }else{
            drGroupsRepo.save(drGroups);
        }
        return "redirect:/groups";
    }
    @RequestMapping("/delete/{id}")
    public String postDelete(@PathVariable(value = "id")Integer id, Model model){
        drGroupsRepo.deleteById(id);
        return "redirect:/groups";
    }

}
