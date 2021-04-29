package com.test.application.model.credit;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int value;
    @OneToMany(mappedBy="rate")
    private Set<Credit> credits;
}
