package com.example.withfront.service;

import com.example.withfront.model.MyResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.minidev.json.parser.JSONParser;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class RemoteRest {
    public String getResponse(String method) throws IOException {
        URL url = new URL ("http://192.168.17.81:8080/RPC");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        StringBuilder response = new StringBuilder();
        con.setRequestMethod("POST");

        JSONParser jsonParser;
        MyResponse jsonpObject = null;
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"jsonrpc\": \"2.0\", \"method\":\"dlg.stats_active\"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine ;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        return  response.toString() ;
    }

    public static void main(String[] args) throws IOException {
        RemoteRest remoteRest=new RemoteRest();
        String response = remoteRest.getResponse("");
        JSONObject jsonObject =new JSONObject(response);
        JSONObject string = jsonObject.getJSONObject("result");
        Object all = string.get("all");
        System.out.println(all);
    }
}
