package com.inventorymanagementsystem.pointofsale.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int id;

    private String name;

    private String country;

    @OneToMany
    private List<Order> ordersList;

}
