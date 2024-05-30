package com.impractice.springbootMySQL.entity.payments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, PaymentKey> {
    List<Payment> findByIdCustomerNumber(Integer customerNumber);
    List<Payment> findByIdCheckNumber(String checkNumber);
}
