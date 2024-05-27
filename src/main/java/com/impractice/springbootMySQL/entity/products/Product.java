package com.impractice.springbootMySQL.entity.products;

import com.impractice.springbootMySQL.entity.employees.Employee;
import com.impractice.springbootMySQL.entity.productLines.ProductLine;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product {
    @Id
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;

    @ManyToOne(optional=false, targetEntity = ProductLine.class)
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false)
    private ProductLine productLine;

    @Column(name = "productScale")
    private String productScale;
    @Column(name = "productVendor")
    private String productVendor;
    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "quantityInStock")
    private Integer quantityInStock;
    @Column(name = "buyPrice")
    private BigDecimal buyPrice;
    @Column(name = "MSRP")
    private BigDecimal MSRP;
}
