package com.impractice.springbootMySQL.entity.employees;

import com.impractice.springbootMySQL.entity.offices.OfficeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        if (employee.getOfficeCode() == null) {
            return EntityModel.of(employee,
                    linkTo(methodOn(EmployeeController.class).getEmployee(employee.getEmployeeNumber())).withSelfRel(),
                    linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("employee"));

        }else{return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).getEmployee(employee.getEmployeeNumber())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("employee"),
                linkTo(methodOn(OfficeController.class).getOffice(employee.getOfficeCode().getOfficeCode())).withRel("office"));

        }

    }
}
