package com.test.application.model.user;

import com.test.application.model.credit.Credit;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    @Size(min = 12,max = 12,message = "ИИН должно состоить из 12 символов")
    private String iin;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String name;
    @NotEmpty
    private String patronymic;
    @NotEmpty
    private String mobileNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private String gender;
    @Min(value = 0)
    @Column(nullable = false)
    private long docNum;
    @NotEmpty
    private String issuedBy;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIssue;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validFor;
    @Min(value = 1)
    private long salary;
    @Min(value = 1)
    private long utilities;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
