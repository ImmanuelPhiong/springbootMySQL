package com.impractice.springbootMySQL.entity.payments;

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
public class PaymentKey implements Serializable {
    @Column(name="customerNumber")
    private Integer customerNumber;

    @Column(name="checkNumber")
    private String checkNumber;
}
