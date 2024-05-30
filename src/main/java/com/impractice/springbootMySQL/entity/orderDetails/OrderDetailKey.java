package com.impractice.springbootMySQL.entity.orderDetails;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderDetailKey implements Serializable {
    @Column(name="orderNumber")
    private Integer orderNumber;

    @Column(name="productCode")
    private String productCode;
}
