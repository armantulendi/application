package com.example.withfront.controller;

import com.example.withfront.repo.subscriber.LocationRepo;
import com.example.withfront.repo.subscriber.SubscriberRepo;
import com.example.withfront.service.ConnectToDB;
import com.example.withfront.service.RemoteRest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
public class MainController {
    @Autowired
    private ConnectToDB connectToDB;
    @Autowired
    private SubscriberRepo subscriberRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private RemoteRest remoteRest;
    @RequestMapping
    public String main(Model model){
        long countCalls=subscriberRepo.count();
        long countRegCallers=locationRepo.countReg();
        model.addAttribute("count",connectToDB.countInTheOneDay());
        model.addAttribute("average",connectToDB.getAverageTimeOfDiscuss());
        model.addAttribute("missedCalls",connectToDB.getCountMissedCalls());
        model.addAttribute("countCalls",countCalls);
        model.addAttribute("countRegCallers",countRegCallers);
        model.addAttribute("countNotRegCallers",countCalls-countRegCallers);
        return "index";
    }
    @GetMapping("monitor")
    public String monitor(Model model){
        JSONObject jsonObject  ;
        String response1;
        String response2;
            response1 = remoteRest.getResponse("dlg.stats_active");
            jsonObject= new JSONObject(response1).getJSONObject("result");

            model.addAttribute("all",jsonObject.get("all").toString());
            model.addAttribute("connecting",jsonObject.get("connecting").toString());
            model.addAttribute("starting",jsonObject.get("starting").toString());
            model.addAttribute("answering",jsonObject.get("answering").toString());
            model.addAttribute("ongoing",jsonObject.get("ongoing").toString());
            model.addAttribute("jsonObject",jsonObject);

            response2 = remoteRest.getResponse("dlg.list");
            JSONArray jsonObject1= new JSONObject(response2).getJSONArray("result");
            for (int i = 0; i < jsonObject1.length(); i++) {
                JSONObject jsonObject2 = jsonObject1.getJSONObject(i);
                Object sessionId=jsonObject2.get("call-id");
                String contactCaller= jsonObject2.getJSONObject("caller").getString("contact");
                String contactCallee= jsonObject2.getJSONObject("callee").getString("contact");
                contactCaller=contactCaller.split(";")[0];
                model.addAttribute("sessionId",sessionId);
                model.addAttribute("contactCaller",contactCaller);
                model.addAttribute("contactCallee",contactCallee);
            }


        return "monitor";
    }

}
