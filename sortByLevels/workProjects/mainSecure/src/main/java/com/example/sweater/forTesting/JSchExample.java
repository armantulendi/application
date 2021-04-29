package com.example.sweater.forTesting;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
/**
 * This program enables you to connect to sshd server and get the shell prompt.
 *   $ CLASSPATH=.:../build javac Shell.java
 *   $ CLASSPATH=.:../build java Shell
 * You will be asked username, hostname and passwd.
 * If everything works fine, you will get the shell prompt. Output may
 * be ugly because of lacks of terminal-emulation, but you can issue commands.
 *
 */
import com.jcraft.jsch.*;
import java.awt.*;
import javax.swing.*;

public class JSchExample{
    public static void main(String[] arg) {
//
//        try {
//            JSch jsch = new JSch();
//            Session session=jsch.getSession("user","192.168.17.97");
//            session.setPassword("123123");
//            session.connect(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}