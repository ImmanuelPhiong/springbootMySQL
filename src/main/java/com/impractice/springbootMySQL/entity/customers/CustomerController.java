package com.impractice.springbootMySQL.entity.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public String createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return "Customer created successfully";
    }

    @PutMapping()
    public String updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return "Customer updated successfully";
    }

    @DeleteMapping("/{customerNumber}")
    public String deleteCustomer(@PathVariable Integer customerNumber){
        customerService.deleteCustomer(customerNumber);
        return "Customer deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Customer>> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{customerNumber}")
    public EntityModel<Customer> getCustomer(@PathVariable Integer customerNumber){
        return customerService.getCustomer(customerNumber);
    }
}
