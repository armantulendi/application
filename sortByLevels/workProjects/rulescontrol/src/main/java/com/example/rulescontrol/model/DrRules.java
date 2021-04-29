package com.example.rulescontrol.model;

import javax.persistence.*;

@Entity
@Table(name = "dr_rules")
public class DrRules {
    @Id
    @Column(name = "ruleid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ruleId;
    @Column(name = "groupid")
//    @NotEmpty(message = "пустое поле")
    private String groupId;
    private String prefix;
    @Column(name = "timerec")
    private String timeRec;
//    @Min(value = 0,message = "меньше 0")
    private int priority;
    @Column(name = "routeid")
//    @NotEmpty(message = "пустое поле")
    private String routeId;
    private String description;
    @Column(name = "gwlist")
//    @NotEmpty(message = "пустое поле")
    private String gwList;
    public DrRules() {
    }


    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGwList() {
        return gwList;
    }

    public void setGwList(String gwList) {
        this.gwList = gwList;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTimeRec() {
        return timeRec;
    }

    public void setTimeRec(String timeRec) {
        this.timeRec = timeRec;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
