package com.example.rulescontrol.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StreamExamples {
    public static void main(String[] args) {
        try {
            FileOutputStream fos=new FileOutputStream("C:/Users/Арман/IdeaProjects/WORK/sortByLevels/workProjects/rulescontrol/springLog.txt");
            fos.write("Привет".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
