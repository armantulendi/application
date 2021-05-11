package com.test.application.model.user;

import com.test.application.model.credit.Term;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String date;
    private Integer term;
    private String iin;
    private String sum;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
