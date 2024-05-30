package com.impractice.springbootMySQL.entity.customers;

import com.impractice.springbootMySQL.entity.employees.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer customer) {
        if (customer.getSalesRepEmployeeNumber() != null){
        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).getCustomer(customer.getCustomerNumber())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).getAllCustomer()).withRel("customer"),
                linkTo(methodOn(EmployeeController.class).getEmployee(customer.getSalesRepEmployeeNumber().getEmployeeNumber()))
                        .withRel("salesRep"));
    }
        else {return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).getCustomer(customer.getCustomerNumber())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).getAllCustomer()).withRel("customer"));
        }
    }
}
