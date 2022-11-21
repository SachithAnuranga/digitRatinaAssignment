package com.inventorymanagementsystem.pointofsale.customer;

import com.inventorymanagementsystem.pointofsale.dto.CustomerDTO;
import com.inventorymanagementsystem.pointofsale.entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        try {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }

       return customerDTO;
    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = null;
        try {
            customerList = customerRepo.findAll();
        }catch (Exception ex){
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }

       return modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        try{
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }catch (Exception ex){
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }

        return customerDTO;
    }

    public void deleteCustomer(CustomerDTO customerDTO) {
        try {
            Customer customer = modelMapper.map(customerDTO, Customer.class);
            customerRepo.delete(customer);
        }catch (Exception ex){
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
