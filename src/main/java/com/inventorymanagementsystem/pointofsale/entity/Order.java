package com.inventorymanagementsystem.pointofsale.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int id;

    private Date orderDate;

    @ManyToOne
    private Customer customer;
}
