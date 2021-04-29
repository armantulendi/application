package com.project.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "dr_groups")
public class DrGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int idGroup;
    @Column(name="username")
//    @NotEmpty(message = "пустое поле")
    private String userName;
//    @NotEmpty(message = "пустое поле")
    private String domain;
    private String description;
    @Column(name = "groupid")
//    @NotEmpty(message = "пустое поле")
    private int drRules;
    public DrGroups() {
    }

    public DrGroups(int idGroup) {
        this.idGroup = idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getDrRules() {
        return drRules;
    }

    public void setDrRules(int drRules) {
        this.drRules = drRules;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
