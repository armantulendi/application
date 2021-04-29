package com.example.rulescontrol.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Process1 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb=new ProcessBuilder("ipconfig","windows-1251");
        InputStream oi=pb.start().getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(oi));
        String s;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
}
