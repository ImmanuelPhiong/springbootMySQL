package com.impractice.springbootMySQL.entity.employees;

import com.impractice.springbootMySQL.entity.customers.CustomerController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).getEmployee(employee.getEmployeeNumber())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("employee"));

    }
}
