package com.inventorymanagementsystem.pointofsale.order;

import com.inventorymanagementsystem.pointofsale.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all-orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add-order")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @PutMapping("/update")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestBody OrderDTO orderDTO) {
        orderService.deleteOrder(orderDTO);
    }
}
