package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "dr_gateways")
public class DrGateway {
    @Id
    @Column(name = "gwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gwId;
    private int type;
    @Column(name = "address")
    private String gwAddress;
    int strip;
    @Column(name = "pri_prefix")
    private String priPrefix;
    private String attrs;
    private String description;


  }
