package com.example.withfront.service;

import com.example.withfront.config.Variables;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SshService {
    Session session = null;
    ChannelExec channelExec = null;
    String hostname = Variables.getDATABASE();
    String username = Variables.getUSERNAME();
    String password =Variables.getDatabasePass();
    InputStream in;
    InputStream err;
    String command1 = "ngrep -W byline -d ens192 port";
    String param1 = "5060";
    String str = "";
    File file;
    BufferedReader reader;
    public SshService() {
        try {

            session = new JSch().getSession(username, hostname, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            try{
                session.connect(2000);
            }catch (Exception e){
                session.disconnect();
            }
        } catch (JSchException  e) {
            session.disconnect();
            System.out.println(e.getMessage());
        }
    }
    public void commandStart(String folder) {
        try {
            channelExec = (ChannelExec) session.openChannel("exec");

            in = channelExec.getInputStream();
            err = channelExec.getErrStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            channelExec.setCommand(command1 + " " + param1);
            channelExec.connect();
            Path path= Paths.get(folder);
            Files.createDirectories(path);
            file = new File(dateFormat()+".log");
            try (FileWriter fileWriter = new FileWriter(folder+"/"+file, true)) {
                do {
                    System.out.print(new Date() + ":");
                    System.out.println(bufferedReader.readLine());
                    if ((str = bufferedReader.readLine()) != null)
                        fileWriter.write(new Date() + ": " + str + "\n");
                    fileWriter.flush();
                } while (session.isConnected());
            }
        } catch (JSchException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sshStop() {
        if (session.isConnected()){
            channelExec.disconnect();
            session.disconnect( );
        }
    }

    //    public static void main(String[] args) throws FileNotFoundException {
//        SshService sshService=new SshService();
//        List<String> list=new LinkedList<>();
//        list=sshService.fileRead("sip","/home/arman/x22");
//
//    }
    @SneakyThrows
    public List<String> fileRead(String filter, String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        reader = new BufferedReader(new FileReader(fileName));

        String line;int n=0;int b=0;

        while(n<100) {
            if(reader.readLine().contains(filter)) {
                b++;
                list.add(reader.readLine());
            }n++;
        }


        return list;
    }

    public static String dateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"+"-"+"dd-MM-yyyy");
        return dateFormat.format( new Date() ) ;
    }
}
