package com.example.withfront.test;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFilterExam {
    public String fileRead(){

        return "";
    }
    @SneakyThrows
    public static    void main(String[] args) {
        String s1;BufferedReader is;Pattern pattern;Matcher matcher;
        String s="asfdqwe qwerwefsd fsffer erdfs hello" +
                "qwerqwe sdfg 2015";
        do{
            System.out.print("Input filter:");
            is=new BufferedReader(new InputStreamReader(System.in));
            s1=is.readLine();

            pattern=Pattern.compile(s1);
            matcher=pattern.matcher(s);

            boolean has=matcher.find();
            if (has)
                System.out.println(s);
            else
                System.out.println("has not");
        }while (!s1.equals("stop"));
    }
}
class FilterTest2{

    public static void old() {
        try {
            long s=0;
            s=new Date().getTime();
            int count = 0;


            BufferedReader reader = new BufferedReader(
                    new FileReader("/home/arman/x22"));
            String line;
            while((line = reader.readLine()) != null) {
                if((line.contains("SIP"))) {
                    System.out.println(line);
                }
            }

            System.out.println("count:"+count);
            System.out.println("time:"+(new Date().getTime()-s));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void newMethod() {
          try {
           Files.lines(Paths.get("/home/arman/x22"))
                    .filter(s -> s.contains("08:32:22")).forEach(System.out::println);
//                    .count();
//            System.out.println("lines"+lines.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
     }
    public static void main(String[] args)  {
        long n=0;
        System.out.println(System.nanoTime());
        old();
        System.out.println(System.nanoTime()-n);
//        System.out.println(System.nanoTime());
//        newMethod();
//        System.out.println(System.nanoTime()-n);
    }
}
