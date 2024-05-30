package com.impractice.springbootMySQL.entity.orderDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impractice.springbootMySQL.entity.orders.Order;
import com.impractice.springbootMySQL.entity.products.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="orderDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetail {
    @EmbeddedId
    OrderDetailKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderNumber")
    @JoinColumn(name="orderNumber")
    private Order orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productCode")
    @JoinColumn(name="productCode")
    private Product productCode;

    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber")
    private Integer orderLineNumber;
}
