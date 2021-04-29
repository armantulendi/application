package com.example.withfront.controller;

import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.Dialplan;
import com.example.withfront.repo.subscriber.DialplanRepo;
import com.example.withfront.service.ControlService;
import com.example.withfront.test.Ssh;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("control-input-routes")
public class ControlInputRoutes {
    private final ControlService controlService;
    private final DialplanRepo dialplanRepo;

    public ControlInputRoutes(ControlService controlService, DialplanRepo dialplanRepo) {
        this.controlService = controlService;
        this.dialplanRepo = dialplanRepo;
    }

    @RequestMapping
    public String greeting(@RequestParam(required=false,defaultValue="") String filter, Model model ) {
        List<Dialplan> data;
        if (filter==null||filter.isEmpty()){
            data = dialplanRepo.findAll();
        }
        else{
            data = dialplanRepo.findAllByMatchExp(filter);
        }
        model.addAttribute("dialplans",data);
        return "control-input-routes";
    }
    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Optional<Dialplan> data = dialplanRepo.findById(id.get());
            if (data.isPresent()) {
                Dialplan dialplan = data.get();
            model.addAttribute("dialplan", dialplan);}
        } else {
            model.addAttribute("dialplan", new Dialplan());
        }
        return "control-input-routes-add";
    }
    @RequestMapping(path = {"/add"})
    public String createOrUpdate(@Valid Dialplan dialplan, BindingResult bindingResult)  {
        controlService.addDiaplan(dialplan,bindingResult);
        return "redirect:/control-input-routes";
    }

    @RequestMapping("/delete/{id}")
    public String postDelete(@PathVariable(value = "id")Integer id, Model model){
        dialplanRepo.deleteById(id);
        return "redirect:/control-input-routes";
    }
    @PostMapping
    public String activate(Model model){
        List<String> list=Ssh.reload("kamcmd dialplan.reload");
//        if (list.get(0).equals("")&&list.get(1).equals(""))
//        model.addAttribute("reload","применено");
        return "redirect:/control-input-routes";
    }
}
