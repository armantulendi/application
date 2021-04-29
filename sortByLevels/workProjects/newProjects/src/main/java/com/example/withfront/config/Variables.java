package com.example.withfront.config;

public  class Variables {
    private static final String REMOTE_HOST = "192.168.17.81";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "QWE@1234";

    private static final String SIP_PROXY1 ="192.168.17.81";//sip-proxy1.dom.loc //10.22.34.104(sip-proxy1)
    private static final String SIP_PROXY1PASS ="QWE@1234";
    private static final String SIP_PROXY2 = "192.168.17.82";//sip-proxy1.dom.loc //10.22.34.203(sip-proxy2)
    private static final String SIP_PROXY2PASS ="QWEdsa@123";
    private static final int REMOTE_PORT = 22;

    private static final String DATABASE ="192.168.17.83";//sip-db.dom.loc// 10.22.34.212(БД)
    private static final String DATABASE_PASS ="QWE@1234";
    private static final String DATABASE_USER ="root";

    public static String getRemoteHost() {
        return REMOTE_HOST;
    }

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getDatabasePass() {
        return DATABASE_PASS;
    }

    public static String getDatabaseUser() {
        return DATABASE_USER;
    }

    public static String getSipProxy1pass() {
        return SIP_PROXY1PASS;
    }

    public static String getSipProxy2pass() {
        return SIP_PROXY2PASS;
    }

    public static String getSipProxy1() {
        return SIP_PROXY1;
    }

    public static String getSipProxy2() {
        return SIP_PROXY2;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static int getRemotePort() {
        return REMOTE_PORT;
    }
}
