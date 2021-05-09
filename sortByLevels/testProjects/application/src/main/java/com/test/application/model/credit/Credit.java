package com.test.application.model.credit;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String sum;
    @ManyToOne
    @JoinColumn(name="rate_id", nullable=false)
    private Rate rate;
    @ManyToOne
    @JoinColumn(name="term_id", nullable=false)
    private Term term;
}
