package com.example.rulescontrol.example;

import com.jcraft.jsch.*;

public class Sftp {
    private static final String REMOTE_HOST = "192.168.17.97";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "123123";
    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;
    public static void main(String[] args) {
//        String localFile = "C:/Users/Арман/IdeaProjects/WORK/sortByLevels/workProjects/rulescontrol/text.txt";
//        String remoteFile = "C:/Users/Арман/IdeaProjects/WORK/sortByLevels/workProjects/rulescontrol/text1.txt";
        Session jschSession = null;
        try {
            JSch jsch = new JSch();
            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
            jschSession.setConfig("StrictHostKeyChecking", "no");
            // authenticate using private key
            // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");
            // authenticate using password
            jschSession.setPassword(PASSWORD);
            // 10 seconds session timeout
            jschSession.connect(SESSION_TIMEOUT);
            Channel sftp = jschSession.openChannel("sftp");
            // 5 seconds timeout
            sftp.connect(CHANNEL_TIMEOUT);
            ChannelSftp channelSftp = (ChannelSftp) sftp;
            // transfer file from local to remote server
            channelSftp.get(channelSftp.getHome()+"/todownload.txt","C:/Users/Арман/IdeaProjects/WORK/sortByLevels/workProjects/rulescontrol");
            // download file from remote server to local
            // channelSftp.get(remoteFile, localFile);
            channelSftp.exit();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }
        System.out.println("Done");
    }
}