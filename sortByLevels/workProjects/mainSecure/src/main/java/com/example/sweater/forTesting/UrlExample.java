package com.example.sweater.forTesting;

import java.net.URL;

public class UrlExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080");
            System.out.println(url.getAuthority());;
            System.out.println(url.getAuthority());;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
