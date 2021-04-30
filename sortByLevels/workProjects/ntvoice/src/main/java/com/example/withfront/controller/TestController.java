package com.example.withfront.controller;

import com.example.withfront.model.MyBody;
import com.example.withfront.model.MyResponse;
import com.example.withfront.model.Result;
import com.example.withfront.service.RemoteRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;


@RestController
@RequestMapping(value = "/test",produces = "application/json")
public class TestController {
    @Autowired
    private RemoteRest remoteRest;
    @GetMapping
    public String get(Model model){
        model.addAttribute("");
        return "";
    }
    @PostMapping
    public String  get(@RequestParam String method) throws  Exception {

        return "";
    }



}
