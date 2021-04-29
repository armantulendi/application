package com.example.rulescontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Controller
public class FileDownloadController {
    String folderPath="C:\\Users\\Арман\\IdeaProjects\\WORK\\sortByLevels\\workProjects\\rulescontrol\\";
    @RequestMapping("file")
    public String showFiles(Model model){
        File folder=new File(folderPath);
        File[] folderList =folder.listFiles();
        model.addAttribute("files",folderList);
        return "downloadFile";
    }
    @RequestMapping("/file/{fileName}")
    @ResponseBody
    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response){
//        if (fileName.contains(".doc")) response.setContentType("application/msword");
//        if (fileName.contains(".docx")) response.setContentType("application/msword");
//        if (fileName.contains(".xls")) response.setContentType("application/vnd.ms-excel");
//        if (fileName.contains(".csv")) response.setContentType("application/vnd.ms-excel");
//        if (fileName.contains(".ppt")) response.setContentType("application/ppt");
//        if (fileName.contains(".pdf")) response.setContentType("application/pdf");
//        if (fileName.contains(".zip")) response.setContentType("application/zip");
        response.setHeader("Content-Disposition","attachment;filename"+fileName);
        response.setHeader("Content-Transfer-Encoding","binary");
        try{
            BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
            Scanner scanner=new Scanner(new File(folderPath+fileName));
            while (scanner.hasNextLine()){
                bos.write((scanner.nextLine()+"\n").getBytes(StandardCharsets.UTF_8));
            }
            bos.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
