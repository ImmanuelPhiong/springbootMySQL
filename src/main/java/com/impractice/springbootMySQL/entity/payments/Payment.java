package com.impractice.springbootMySQL.entity.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impractice.springbootMySQL.entity.customers.Customer;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {
    @EmbeddedId
    PaymentKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerNumber")
    @JoinColumn(name="customerNumber")
    private Customer customerNumber;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;
}
