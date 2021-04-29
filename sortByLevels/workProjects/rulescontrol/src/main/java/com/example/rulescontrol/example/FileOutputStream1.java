package com.example.rulescontrol.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileOutputStream1 {
    public FileOutputStream1(String s) {
    }

    public static void main(String[] args) {
        FileInputStream fis=null;
        InputStreamReader isr=null;
        int b;
        {
            try {
                fis = new FileInputStream("C:/Users/Арман/IdeaProjects/WORK/sortByLevels/workProjects/rulescontrol/springLog.txt");
                isr=new InputStreamReader(fis, StandardCharsets.UTF_8);
                while ((b=isr.read())!=-1){
                    System.out.print((char)b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
