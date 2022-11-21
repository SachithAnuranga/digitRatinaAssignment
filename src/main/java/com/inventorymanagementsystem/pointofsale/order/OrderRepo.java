package com.inventorymanagementsystem.pointofsale.order;

import com.inventorymanagementsystem.pointofsale.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
