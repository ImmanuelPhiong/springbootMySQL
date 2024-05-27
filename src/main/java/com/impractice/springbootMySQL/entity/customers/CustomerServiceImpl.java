package com.impractice.springbootMySQL.entity.customers;

import com.impractice.springbootMySQL.entity.customers.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private  CustomerModelAssembler customerModelAssembler;


    @Override
    public String createCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }

    @Override
    public String updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }

    @Override
    public String deleteCustomer(Integer customerNumber) {
        customerRepository.deleteById(customerNumber);
        return "Success";
    }

    @Override
    public EntityModel<Customer> getCustomer(Integer customerNumber) {
        if(customerRepository.findById(customerNumber).isEmpty()){
            throw new CustomerNotFoundException("Customer with customerNumber: " + customerNumber + " is not exist");
        }
        Customer customer = customerRepository.findById(customerNumber).get();
        return customerModelAssembler.toModel(customer);
    }

    @Override
    public CollectionModel<EntityModel<Customer>> getAllCustomer() {
        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(customerModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).getAllCustomer()).withSelfRel());
    }
}
