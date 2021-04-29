package com.example.rulescontrol.controller;

import com.example.rulescontrol.model.Subscriber;
import com.example.rulescontrol.repo.SubscriberRepo;
import com.example.rulescontrol.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("subscribe")
public class SubscribeController {

    @Autowired
    SubscriberRepo subscriberRepo;
    SubscriberService subscriberService;
    @GetMapping
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
        return "subscribe";
    }
    @PostMapping
    public String addSubscribe(@RequestParam String username,
                               @RequestParam String domain,
                               @RequestParam String password,
                               Subscriber subscriber,
                               Model model) throws NoSuchAlgorithmException {
        Subscriber newSubscriber=new Subscriber();
        newSubscriber.setUsername(username);
        newSubscriber.setDomain(domain);
        newSubscriber.setPassword(password);
        newSubscriber.setHa1(getMD5(username));
        newSubscriber.setHa1b(getMD5(password));
        subscriberRepo.save(newSubscriber);
    return "redirect:/subscribe";}

    @PostMapping("{id}")
    public String postDelete(@PathVariable Integer id, Model model){
        subscriberRepo.deleteById(id);
        return "redirect:/subscribe";
    }
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
