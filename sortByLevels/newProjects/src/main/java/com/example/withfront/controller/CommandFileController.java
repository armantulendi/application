package com.example.withfront.controller;

import com.example.withfront.service.SshService;
import com.example.withfront.service.SystemService;
import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/command")
public class CommandFileController   {
    @Autowired
    private SystemService systemService;

    @Autowired
    private SshService sshService;
    @GetMapping
    public String getCommand(Model model) throws FileNotFoundException {
        File[] files=systemService.getFolder().listFiles();

        model.addAttribute("files",files);
        return "commands";
    }

    @RequestMapping("/startCommand")
    public String startCommand(
            @RequestParam(defaultValue = "ngrep -W byline -d ens192 port") String command,
            @RequestParam(defaultValue = "5060") String port)
            throws IOException, JSchException {
        sshService=new SshService();
        sshService.commandStart(command,port,systemService.getFolder().toString());
        return "redirect:/command";
    }
    @RequestMapping("/stop")
    public String stop(Model model){
        sshService.sshStop();
        return "redirect:/command";
    }
//    @RequestMapping("/file/{fileName}/read")
//    public String fileRead(Model model, @PathVariable String fileName){
//        try {
//            List<String> list=sshService.fileRead(files);
//            model.addAttribute("file",list);
//            getCommand(model);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "commands";
//    }
    @RequestMapping("/file/{fileName}")
    @ResponseBody
    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response){
        response.setHeader("Content-Disposition","attachment;filename"+fileName);
        response.setHeader("Content-Transfer-Encoding","binary");
        try{
            BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
            Scanner scanner=new Scanner(new File(systemService.getFolder()+"/"+fileName));
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
