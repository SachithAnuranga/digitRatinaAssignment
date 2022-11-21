package com.inventorymanagementsystem.pointofsale.customer;

import com.inventorymanagementsystem.pointofsale.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all-customers")
    public List<CustomerDTO> getAllCustomers() {
     return customerService.getAllCustomer();
    }

    @PostMapping("/add-customer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
      return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
      return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.deleteCustomer(customerDTO);
    }

}
