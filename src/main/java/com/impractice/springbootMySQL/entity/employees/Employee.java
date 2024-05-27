package com.impractice.springbootMySQL.entity.employees;

import com.fasterxml.jackson.annotation.*;
import com.impractice.springbootMySQL.entity.customers.Customer;
import com.impractice.springbootMySQL.entity.offices.Office;
import com.impractice.springbootMySQL.entity.orders.Order;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"employees", "customers", "orders"})
public class Employee {
    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "extension")
    private String extension;
    @Column(name = "email")
    private String email;

    @ManyToOne(optional = true, targetEntity = Office.class)
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode",nullable = true)
    private Office officeCode;

    @ManyToOne(optional=true, targetEntity = Employee.class)
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber", nullable = true)
    private Employee reportsTo;

    @Column(name = "jobTitle")
    private String jobTitle;

    // for the foreign key
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salesRepEmployeeNumber")
    @JsonIgnore
    private List<Customer> customers;


    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportsTo")
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerNumber")
    @JsonIgnore
    private List<Order> orders;
}
