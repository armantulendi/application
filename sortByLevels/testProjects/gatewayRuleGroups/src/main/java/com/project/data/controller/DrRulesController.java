package com.project.data.controller;

import com.project.data.example.Ssh;
import com.project.data.model.DrGateway;
import com.project.data.model.DrRules;
import com.project.data.repo.DrGatewayRepo;
import com.project.data.repo.DrRulesRepo;

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
//        dr.setTimeRec(drRules.getTimeRec());
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
