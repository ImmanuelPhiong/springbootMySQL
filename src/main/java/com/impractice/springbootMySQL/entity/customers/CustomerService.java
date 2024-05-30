package com.impractice.springbootMySQL.entity.customers;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


public interface CustomerService {
    public String createCustomer(Customer customer);
    public String updateCustomer(Customer customer);
    public String deleteCustomer(Integer customerNumber);
    public EntityModel<Customer> getCustomer(Integer customerNumber);
    public CollectionModel<EntityModel<Customer>> getAllCustomer();
}
