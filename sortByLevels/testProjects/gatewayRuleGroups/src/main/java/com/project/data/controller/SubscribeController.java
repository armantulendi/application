package com.project.data.controller;

import com.project.data.model.Subscriber;
import com.project.data.repo.SubscriberRepo;
import com.project.data.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class SubscribeController {

    @Autowired
    SubscriberRepo subscriberRepo;
    SubscriberService subscriberService;
    @GetMapping("/main")
    public String greeting( @RequestParam(required=false,defaultValue="") String filter, Model model ) {
//        model.addAttribute("password",subscriber.getPassword());
        Iterable<Subscriber> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = subscriberRepo.getAllByUsername(filter);
        } else {
            messages = subscriberRepo.findAll();
        }
        model.addAttribute("subscriberData",messages);
        model.addAttribute("username",filter);
        return "greeting";
    }
    @GetMapping("/main/{id}")
    public String getDelete(@PathVariable Integer id, Model model){

        return "redirect:/main";
    }
    @PostMapping("/main/{id}")
    public String postDelete(@PathVariable Integer id, Model model){
        subscriberRepo.deleteById(id);
        return "redirect:/main";
    }

    @PostMapping("/main")
    public String addSubscribe(@RequestParam String username,
                               @RequestParam String domain,
                               @RequestParam String password,
                               Subscriber subscriber,
                               Model model) throws NoSuchAlgorithmException {
        Subscriber newSubscriber=new Subscriber();
        newSubscriber.setUsername(username);
        newSubscriber.setDomain(domain);
        newSubscriber.setPassword(password);
        String usernameMD5=getMD5(username);
        String passwordMD5=getMD5(password);
        newSubscriber.setHa1(usernameMD5);
        newSubscriber.setHa1b(passwordMD5);
        subscriberRepo.save(newSubscriber);
    return "redirect:/main";}
    public static String getMD5(String data) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        messageDigest.update(data.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

}
