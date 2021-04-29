package com.test.application.model.credit;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int value;
    @OneToMany(mappedBy="term")
    private Set<Credit> credits;
}
