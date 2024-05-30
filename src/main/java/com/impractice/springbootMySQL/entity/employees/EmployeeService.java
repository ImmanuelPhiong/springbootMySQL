package com.impractice.springbootMySQL.entity.employees;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


public interface EmployeeService {
    public String createEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(Integer employeeNumber);
    public EntityModel<Employee> getEmployee(Integer employeeNumber);
    public CollectionModel<EntityModel<Employee>> getAllEmployee();
}
