package com.impractice.springbootMySQL.entity.payments;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface PaymentService {
    public String createPayment(Payment payment);
    public String updatePayment(Payment payment);
    public String deletePayment(PaymentKey paymentKey);
    public EntityModel<Payment> getPayment(PaymentKey paymentKey);
    public CollectionModel<EntityModel<Payment>> getPaymentbyCustomerNumber(Integer customerNumber);
    public CollectionModel<EntityModel<Payment>> getAllPayment();
}
