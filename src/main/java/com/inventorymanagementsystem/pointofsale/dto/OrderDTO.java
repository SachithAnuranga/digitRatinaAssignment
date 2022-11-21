package com.inventorymanagementsystem.pointofsale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int id;
    private Date orderDate;
    private int customer_id;
}
