package com.example.rulescontrol.example;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class SshExample {

public void ssh(){
    Session session = null;
    ChannelExec channelExec=null;
    String hostname="sip-proxy1.dom.loc";
    String username="root";
    String password="QWE@1234";
    String username1="user";
    String hostname1="192.168.17.97";
    InputStream in;
    InputStream err;
    BufferedReader reader;
    String command1="ngrep -W byline -d ens192 port";
    String param1="5060";
    try {
        session = new JSch().getSession(username, hostname, 22);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        try {
            session.connect();
            channelExec = (ChannelExec) session.openChannel("exec");
//            reader=new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("input command:");
//            String command=reader.readLine();
            channelExec.setCommand(command1+" "+param1);

            in = channelExec.getInputStream();
            err = channelExec.getErrStream();
            channelExec.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            BufferedReader errReader = new BufferedReader(new InputStreamReader(err));
            String str;
            do{
                System.out.print(new Date() +":");
                System.out.println(bufferedReader.readLine());

            }while(session.isConnected());

//            while ((str = bufferedReader.readLine())!= null) {
//                System.out.println(str);
////                    Thread.sleep(5000);
//                    channelExec.disconnect();
//            }
//            while ((str = errReader.readLine()) != null) {
//                System.out.println(str);
//                Thread.sleep(1000);
//            }
            session.disconnect();
        } catch (JSchException | IOException  e) {
            e.printStackTrace();
        }
    } catch (JSchException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) throws InterruptedException {
        SshExample sshExample=new SshExample();
        sshExample.ssh();
    }
}
