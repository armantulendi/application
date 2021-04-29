package com.example.rulescontrol.controller;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ForTheReadingLogs {
    Session session=null;
    public static void main(String[] args) {

    }
    public void connect(String username,String hostname) throws JSchException {
        session= new JSch().getSession(username,hostname);
        session.setPassword("");
        session.setConfig("StrictHostKeyChecking", "no");
    }

}
