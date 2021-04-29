package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Data
@Setter
@Table(name = "dr_groups")
public class DrGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int idGroup;
    @Column(name="username")
    private String userName;
    private String domain;
    private String description;
    @Column(name = "groupid")
    private int drRules;
    public DrGroups() {
    }

   }
