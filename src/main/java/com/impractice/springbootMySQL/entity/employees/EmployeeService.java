package com.impractice.springbootMySQL.entity.employees;

import com.impractice.springbootMySQL.entity.customers.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface EmployeeService {
    public String createEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(Integer employeeNumber);
    public EntityModel<Employee> getEmployee(Integer employeeNumber);
    public CollectionModel<EntityModel<Employee>> getAllEmployee();
}
