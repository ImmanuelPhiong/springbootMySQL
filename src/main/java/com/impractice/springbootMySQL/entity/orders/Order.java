package com.impractice.springbootMySQL.entity.orders;

import com.impractice.springbootMySQL.entity.customers.Customer;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order {
    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;
    @Column(name = "orderDate")
    private Date orderDate;
    @Column(name = "requiredDate")
    private Date requiredDate;
    @Column(name = "shippedDate")
    private Date shippedDate;
    @Column(name = "status")
    private String status;
    @Column(name = "comments")
    private String comments;

    @ManyToOne(optional = false, targetEntity = Customer.class)
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    private Customer customerNumber;
}
