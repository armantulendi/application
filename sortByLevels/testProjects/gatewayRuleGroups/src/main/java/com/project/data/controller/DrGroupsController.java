package com.project.data.controller;

import com.project.data.model.DrGroups;
import com.project.data.model.DrRules;
import com.project.data.repo.DrGatewayRepo;
import com.project.data.repo.DrGroupsRepo;
import com.project.data.repo.DrRulesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class DrGroupsController  {
    @Autowired
    DrGroupsRepo drGroupsRepo;
    @Autowired
    DrRulesRepo drRulesRepo;
    @Autowired
    DrGatewayRepo drGatewayRepo;

    @GetMapping
    @Transactional
    public String getGroups(Model model){
        List<DrRules> rules= drRulesRepo.findAll();
        model.addAttribute("rules",rules);
        List<DrGroups> groups= drGroupsRepo.findAll();
        model.addAttribute("groups",groups);

        return "forGroups";
    }

    @PostMapping("/save")
    public String addSubscribe(@ModelAttribute @Valid DrGroups drGroups,
                               BindingResult bindingResult,
                               Model model)  {
        if (bindingResult.hasErrors())
        drGroupsRepo.save(drGroups);

        return "redirect:/groups";
    }

    @GetMapping("filter")
    public String findByDGroups(@RequestParam(defaultValue = " ") String username,
//                              @RequestParam(defaultValue = " ") String description,
                                Model model){
        if (!username.isEmpty()){
            List<DrGroups> drGroups=drGroupsRepo.findAllByUserName(username);
                model.addAttribute("groups",drGroups);
        }else{
            getGroups(model);
        }
        return "redirect:/groups";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Integer id){
        drGroupsRepo.deleteById(id) ;
        return "redirect:/groups";
    }
    @PostMapping("update")
    public String update(@ModelAttribute @Valid DrGroups drGroups,
                               BindingResult bindingResult,
                               Model model)  {
        if (bindingResult.hasErrors())
            return "forGroups";
       DrGroups dr= drGroupsRepo.findByIdGroup(drGroups.getIdGroup());
          dr.setDomain(drGroups.getDomain());
          dr.setDrRules(drGroups.getDrRules());
          dr.setDescription(drGroups.getDescription());
          dr.setUserName(drGroups.getUserName());
          drGroupsRepo.save(dr);
        return "redirect:/groups";
    }
}
