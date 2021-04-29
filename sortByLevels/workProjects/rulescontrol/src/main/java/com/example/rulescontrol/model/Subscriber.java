package com.example.rulescontrol.model;

import javax.persistence.*;

@Entity
@Table(name="subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String domain;
    private String password;
    private String ha1;
    private String ha1b;

    public Subscriber() {
    }

    public String getHa1() {
        return ha1;
    }

    public void setHa1(String ha1) {
        this.ha1 = ha1;
    }

    public String getHa1b() {
        return ha1b;
    }

    public void setHa1b(String ha1b) {
        this.ha1b = ha1b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
