package com.project.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "dr_gateways")
public class DrGateway {
    @Id
    @Column(name = "gwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gwId;
    private int type;
    @Column(name = "address")
//    @NotEmpty(message = "введите адрес")
    private String gwAddress;
    int strip;
    @Column(name = "pri_prefix")
//    @NotEmpty(message = "пустое поле")
    private String priPrefix;
//    @NotEmpty(message = "пустое поле")
    private String attrs;
    private String description;
//    @OneToMany(mappedBy = "gwList",cascade = CascadeType.REFRESH)
//    private Set<DrRules> drRules;

    public DrGateway() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGwId() {
        return gwId;
    }

    public void setGwId(int gwId) {
        this.gwId = gwId;
    }

    public String getGwAddress() {
        return gwAddress;
    }

    public void setGwAddress(String gwAddress) {
        this.gwAddress = gwAddress;
    }

    public int getStrip() {
        return strip;
    }

    public void setStrip(int strip) {
        this.strip = strip;
    }

    public String getPriPrefix() {
        return priPrefix;
    }

    public void setPriPrefix(String priPrefix) {
        this.priPrefix = priPrefix;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
