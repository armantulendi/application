package com.example.withfront.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SystemService {
    public File getFolder(){
        File resourcePath = null;
        switch (System.getProperty("os.name")) {
            case "Linux":  resourcePath = new File("/tmp/listenPhones");
                break;
            case "Windows 10":  resourcePath = new File("C:\\TMP\\");
                break;
        }
        return resourcePath;
    }

}
