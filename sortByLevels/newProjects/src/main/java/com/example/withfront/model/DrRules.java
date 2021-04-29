package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import javax.persistence.*;

@Entity
@Getter
@Data
@Setter
@Table(name = "dr_rules")
public class DrRules {
    private static final Logger log = Logger.getLogger(DrRules.class);
    @Id
    @Column(name = "ruleid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ruleId;
    @Column(name = "groupid")
    private String groupId;
    private String prefix;
    @Column(name = "timerec")
    private String timeRec;
    private int priority;
    @Column(name = "routeid")
    private String routeId;
    private String description;
    @Column(name = "gwlist")
    private String gwList;

}
