package com.example.withfront.service;

import com.jcraft.jsch.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SshService {
    Session session = null;
    ChannelExec channelExec = null;
    String hostname = "192.168.17.81";
    String username = "root";
    String password = "QWE@1234";
    InputStream in;
    InputStream err;
    String command1 = "ngrep -W byline -d ens192 port";
    String param1 = "5060";
    String str = "";
    File file;
    List<String> list = new LinkedList<>();

    public SshService() {
        try {
            session = new JSch().getSession(username, hostname, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command1 + " " + param1);
            in = channelExec.getInputStream();
            err = channelExec.getErrStream();
            channelExec.connect();
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }
    }
    public void commandStart(String command1, String param1,String folder) throws IOException, JSchException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        file = new File(dateFormat()+UUID.randomUUID().toString()+".log");
        try (FileWriter fileWriter = new FileWriter(folder+"/"+file, true)) {
            do {
                System.out.print(new Date() + ":");
                System.out.println(bufferedReader.readLine());
                if ((str = bufferedReader.readLine()) != null)
                    fileWriter.write(new Date() + ": " + str + "\n");
                fileWriter.flush();
            } while (session.isConnected());
        }
    }

    public void sshStop() {
        channelExec.disconnect();
        session.disconnect();
    }

    public List<String> fileRead(File fileName) throws IOException {
        Scanner scanner;
        list.clear();
        scanner = new Scanner(fileName);
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    public static String dateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-");
        return dateFormat.format( new Date() ) ;
    }
}
//    public static void main(String[] args) throws InterruptedException {
//        SshService sshExample= null;
//        sshExample = new SshService();
//        sshExample.sshStart();

//    }

