package com.impractice.springbootMySQL.entity.employees;

import com.impractice.springbootMySQL.entity.employees.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeModelAssembler employeeModelAssembler;

    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Success";
    }

    @Override
    public String deleteEmployee(Integer employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
        return "Success";
    }

    @Override
    public EntityModel<Employee> getEmployee(Integer employeeNumber) {
        if (employeeRepository.findById(employeeNumber).isEmpty()){
            throw new EmployeeNotFoundException("Employee with employeeNumber: " + employeeNumber + " is not exist");
        }
        Employee employee = employeeRepository.findById(employeeNumber).get();
        return employeeModelAssembler.toModel(employee);
    }

    @Override
    public CollectionModel<EntityModel<Employee>> getAllEmployee() {
        List<EntityModel<Employee>> employees = employeeRepository.findAll().stream()
                .map(employeeModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).getAllEmployee()).withSelfRel());

    }
}
