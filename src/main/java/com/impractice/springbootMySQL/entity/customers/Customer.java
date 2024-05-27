package com.impractice.springbootMySQL.entity.customers;

import com.impractice.springbootMySQL.entity.employees.Employee;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Customer {
    @Id
    @Column(name = "customerNumber")
    private Integer customerNumber;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "contactLastName")
    private String contactLastName;
    @Column(name = "contactFirstName")
    private String contactFirstName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "addressLine1")
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "country")
    private String country;

    @ManyToOne(optional=true, targetEntity = Employee.class)
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber", nullable = true)
    private Employee salesRepEmployeeNumber;

    @Column(name = "creditLimit")
    private BigDecimal creditLimit;
}
