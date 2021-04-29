package com.example.withfront.test;

import com.example.withfront.config.Variables;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ssh {
//    public static void main(String[] args) throws Exception {
//        System.out.println( sshConnect("ls","root","sip-proxy1.dom.loc",22,"QWE@1234",1000));
//        System.out.println(sshConnect("kamcmd drouting.reload","root","sip-proxy2.dom.loc",22,"QWEdsa@123",100));
//
//    }
    //for the controller
    public static List<String> reload( String command){
        List<String> list=new ArrayList<String>(3);
        try {
            list.add( sshConnect(command, Variables.getUSERNAME(),
                    Variables.getSipProxy1(),Variables.getRemotePort(),
                    Variables.getSipProxy1pass(),100));
            list.add( sshConnect(command,Variables.getUSERNAME(),
                    Variables.getSipProxy2(),Variables.getRemotePort(),
                    Variables.getSipProxy2pass(),100));
             return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //for the test

    public static String sshConnect(String command, String username, String hostname, int port,String password,int milliSecond) {
    Session session=null;
    ChannelExec channel=null;
    try{
        //создаем сессию с параметрами для ssh
        session = new JSch().getSession(username,hostname,port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        //проверяем подключение
        try {
            session.connect();
        }catch (Exception e){
            //исключение при неудачной созддании сессии
            e.printStackTrace();
        }
        //создаем канал в сессии
            channel=(ChannelExec) session.openChannel("exec");
        //передаем команду в канал
        channel.setCommand(command);
        //создаем потоки вывода
        ByteArrayOutputStream responseStream=new ByteArrayOutputStream();
        //передаем потоки ввода в канал
        channel.setOutputStream(responseStream);
        //подключчаемся к каналу
        channel.connect();
        //получаем потоки вывода
        channel.getOutputStream().write(5);
        //ждем закрытия канала
//        while(channel.isConnected()){
//            System.out.println(".");
//            Thread.sleep(100);
//        }
        //возвращаем результат команды
        return responseStream.toString();
        //выбрасываем исключение
    }catch (Exception e){
        return e.getMessage();
    }
    finally{
        //в любом случае закрываем сессию
        if (session!=null){
            session.disconnect();
        }
        //в любом случае закрываем канал
        if (channel!=null){
            channel.disconnect();
            }
        }
    }



}
