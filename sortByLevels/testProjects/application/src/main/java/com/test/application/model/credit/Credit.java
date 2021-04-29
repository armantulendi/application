package com.test.application.model.credit;

import com.test.application.model.user.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long sum;
    @ManyToOne
    @JoinColumn(name="rate_id", nullable=false)
    private Rate rate;
    @ManyToOne
    @JoinColumn(name="term_id", nullable=false)
    private Term term;
//    @OneToMany(mappedBy = "credit")
//    private Set<Customer> customer;
}
