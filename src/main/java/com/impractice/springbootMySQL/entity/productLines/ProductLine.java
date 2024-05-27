package com.impractice.springbootMySQL.entity.productLines;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.impractice.springbootMySQL.entity.employees.Employee;
import com.impractice.springbootMySQL.entity.products.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productLines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"products"})
public class ProductLine {
    @Id
    @Column(name = "productLine")
    private String productLine;
    @Column(name = "textDescription")
    private String textDescription;
    @Column(name = "htmlDescription", columnDefinition = "mediumtext")
    private String htmlDescription;
    @Lob
    @Column(name = "image")
    private byte[] image;

    //foreign
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productLine")
    @JsonIgnore
    private List<Product> products;
}
