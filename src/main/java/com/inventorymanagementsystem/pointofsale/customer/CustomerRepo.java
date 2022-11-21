package com.inventorymanagementsystem.pointofsale.customer;

import com.inventorymanagementsystem.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}

