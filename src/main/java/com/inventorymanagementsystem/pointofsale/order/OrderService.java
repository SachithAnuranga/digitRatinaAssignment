package com.inventorymanagementsystem.pointofsale.order;

import com.inventorymanagementsystem.pointofsale.dto.OrderDTO;
import com.inventorymanagementsystem.pointofsale.entity.Customer;
import com.inventorymanagementsystem.pointofsale.entity.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);

        Customer customer = new Customer();
        customer.setId(orderDTO.getCustomer_id());
        order.setCustomer(customer);
        orderRepo.save(order);

        return orderDTO;
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOList = modelMapper.map(orderRepo.findAll(), new TypeToken
                <List<OrderDTO>>(){}.getType());
        for (int i=0; i<orderDTOList.size(); i++){
            try {
                int id = orderRepo.findAll().get(i).getCustomer().getId();
                orderDTOList.get(i).setCustomer_id(id);
            }catch (Exception ex) {
                Logger.getLogger(ex.getMessage());
                ex.printStackTrace();
            }

        }

        return orderDTOList;
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        try {
            Order order = modelMapper.map(orderDTO, Order.class);
            Customer customer = new Customer();
            customer.setId(orderDTO.getCustomer_id());
            order.setCustomer(customer);
            orderRepo.save(order);
        }catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }

       return orderDTO;
    }

    public void deleteOrder(OrderDTO orderDTO) {
        try {
            orderRepo.delete(modelMapper.map(orderDTO, Order.class));
        } catch (Exception ex){
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
