package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="booking_amount")
    private String bookingAmount;
    @Column(name ="created_by")
    private int createdBy;
    @Column(name ="drop_address")
    private String dropAddress;
    @Column(name ="pickup_address")
    private String pickupAddress;

}
