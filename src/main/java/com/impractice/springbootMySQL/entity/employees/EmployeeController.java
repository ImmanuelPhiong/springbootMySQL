package com.impractice.springbootMySQL.entity.employees;

import com.impractice.springbootMySQL.entity.customers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public String createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "Employee created successfully";
    }

    @PutMapping()
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Employee updated successfully";
    }

    @DeleteMapping("/{employeeNumber}")
    public String deleteEmployee(@PathVariable Integer employeeNumber){
        employeeService.deleteEmployee(employeeNumber);
        return "Employee deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Employee>> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeNumber}")
    public EntityModel<Employee> getEmployee(@PathVariable Integer employeeNumber){
        return employeeService.getEmployee(employeeNumber);
    }
}
