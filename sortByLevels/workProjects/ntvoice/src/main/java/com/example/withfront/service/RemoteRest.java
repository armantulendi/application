package com.example.withfront.service;

import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

@Service
public class RemoteRest {
    @Value("${sip.proxy1.ip}")
    String sipProxy1;

    public String getResponse(String method )   {
        HttpURLConnection con;
        URL url ;
        String jsonInputString;
        BufferedReader br;
        String responseLine;
        StringBuilder response= new StringBuilder();
        try {
            url = new URL("http://"+ sipProxy1 +":8080/RPC");
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            jsonInputString = "{\"jsonrpc\": \"2.0\", \"method\":\"" + method + "\"}";
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage()+" Не доступен");
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage()+" Не удается подключиться");
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return  response.toString() ;
    }


//    public static void main(String[] args) throws IOException {
//        RemoteRest remoteRest=new RemoteRest();
//        String response = remoteRest.getResponse("dlg.stats_active");
//        JSONObject jsonObject =new JSONObject(response);
//        JSONObject string = jsonObject.getJSONObject("result");
//        Object all = string.get("all");
//        System.out.println(all);
//    }
}
