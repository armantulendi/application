package com.project.data.example;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ssh {

    //for the controller
    public static List<String> reload( String command){
        List<String> list=new ArrayList<String>(3);
        try {
            list.add( sshConnect(command,"root","sip-proxy1.dom.loc",22,"QWE@1234","exec"));
            list.add( sshConnect(command,"root","sip-proxy2.dom.loc",22,"QWEdsa@123","exec"));
             return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //for the test
    public static void main(String[] args) throws Exception {
        System.out.println( sshConnect("kamcmd drouting.reload","root","sip-proxy1.dom.loc",22,"QWE@1234","exec"));
        System.out.println(sshConnect("kamcmd drouting.reload","root","sip-proxy2.dom.loc",22,"QWEdsa@123","exec"));

    }
    public static String sshConnect(String command, String username, String hostname, int port,String password,String type) throws Exception {
    Session session=null;
    ChannelExec channel=null;
    try{
        session=new JSch().getSession( username,hostname,port );
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        channel=(ChannelExec) session.openChannel(type);
        channel.setCommand(command);
        ByteArrayOutputStream responseStream=new ByteArrayOutputStream();
        channel.setOutputStream(responseStream);
        channel.connect();
        channel.getOutputStream();

        while(channel.isConnected()){
            Thread.sleep(100);
        }
        return responseStream.toString();
    }catch (Exception e){
        return e.getMessage();
    }
    finally{
        if (session!=null){
            session.disconnect();
        }if (channel!=null){
            channel.disconnect();
            }
        }
    }


//    public static void listFolderStructure(String username, String password,
//                                           String host, int port, long defaultTimeoutSeconds, String command) throws IOException {
//
//        SshClient client = SshClient.setUpDefaultClient();
//        client.start();
//
//        try (ClientSession session = client.connect(username, host, port)
//                .verify(defaultTimeoutSeconds, TimeUnit.SECONDS).getSession()) {
//            session.addPasswordIdentity(password);
//            session.auth().verify(defaultTimeoutSeconds, TimeUnit.SECONDS);
//
//            try (ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
//                 ClientChannel channel = session.createChannel(Channel.CHANNEL_SHELL)) {
//                channel.setOut(responseStream);
//                try {
//                    channel.open().verify(defaultTimeoutSeconds, TimeUnit.SECONDS);
//                    try (OutputStream pipedIn = channel.getInvertedIn()) {
//                        pipedIn.write(command.getBytes());
//                        pipedIn.flush();
//                    }
//
//                    channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED),
//                            TimeUnit.SECONDS.toMillis(defaultTimeoutSeconds));
//                    String responseString = responseStream.toString();
//                    System.out.println(responseString);
//                } finally {
//                    channel.close(false);
//                }
//            }
//        } finally {
//            client.stop();
//        }
//    }

}
