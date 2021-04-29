package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "dialplan")
public class Dialplan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dpid")
    private int dpId;
    @Column(name = "match_op")
    private int matchOp;
    private int pr;
    @Column(name = "match_exp")
    private String matchExp;
    @Column(name = "match_len")
    private int matchLen;
    @Column(name = "subst_exp")
    private String substExp;
    @Column(name = "repl_exp")
    private String replExp;
    private String attrs;

}
