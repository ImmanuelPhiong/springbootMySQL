package com.impractice.springbootMySQL.entity.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impractice.springbootMySQL.entity.customers.Customer;
import com.impractice.springbootMySQL.entity.orderDetails.OrderDetail;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"orderDetaillist"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Customer.class)
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    private Customer customerNumber;

    //Bidirectional relationship
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderNumber")
    @JsonIgnore
    private List<OrderDetail> orderDetaillist;
}
