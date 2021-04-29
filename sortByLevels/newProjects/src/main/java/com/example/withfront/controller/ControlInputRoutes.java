package com.example.withfront.controller;

import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.DrGateway;
import com.example.withfront.repo.subscriber.DrGatewayRepo;
import com.example.withfront.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("control-output-routes")
public class ControlInputRoutes {
    @Autowired
     ControlService controlService;
    @Autowired
    private DrGatewayRepo drGatewayRepo;
    @GetMapping
    public String greeting(@RequestParam(required=false,defaultValue="") String filter, Model model ) {
        List<DrGateway> data;
        if (filter==null||filter.isEmpty()){
            data = drGatewayRepo.findAll();
        }
        else{
            data = drGatewayRepo.findAllByAttrs(filter);
        }
        model.addAttribute("drGateways",data);
        return "control-output-routes";
    }
    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            DrGateway data = drGatewayRepo.findByGwId(id.get());
            model.addAttribute("drGateway", data);
        } else {
            model.addAttribute("drGateway", new DrGateway());
        }
        return "control-output-routes-add";
    }
    @RequestMapping(path = {"/add"},method = RequestMethod.POST)
    public String createOrUpdate(@Valid DrGateway drGateway, BindingResult bindingResult)  {
        controlService.addGateway(drGateway,bindingResult);
        return "redirect:/control-output-routes";
    }



    @RequestMapping("/delete/{id}")
    public String postDelete(@PathVariable(value = "id")Integer id, Model model){
        drGatewayRepo.deleteById(id);
        return "redirect:/control-output-routes";
    }

}
