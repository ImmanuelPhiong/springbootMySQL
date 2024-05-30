package com.impractice.springbootMySQL.entity.payments;

import com.impractice.springbootMySQL.entity.payments.exception.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentModelAssembler paymentModelAssembler;

    @Override
    public String createPayment(Payment payment) {
        paymentRepository.save(payment);
        return "Success";
    }

    @Override
    public String updatePayment(Payment payment) {
        paymentRepository.save(payment);
        return "Success";
    }

    @Override
    public String deletePayment(PaymentKey paymentKey) {
        paymentRepository.deleteById(paymentKey);
        return "Success";
    }

    @Override
    public EntityModel<Payment> getPayment(PaymentKey paymentKey) {
        if(paymentRepository.findByIdCheckNumber(paymentKey.getCheckNumber()).isEmpty()){
            throw new PaymentNotFoundException("Payment with CheckNumber: " + paymentKey.getCheckNumber() + " is not exist");
        }
        Payment payment = paymentRepository.findByIdCheckNumber(paymentKey.getCheckNumber()).get(0);
        return paymentModelAssembler.toModel(payment);
    }

    @Override
    public CollectionModel<EntityModel<Payment>> getPaymentbyCustomerNumber(Integer customerNumber) {
        if(paymentRepository.findByIdCustomerNumber(customerNumber).isEmpty()){
            throw new PaymentNotFoundException("Payment with customerNumber: " + customerNumber + " is not exist");
        }
        List<EntityModel<Payment>> payments = paymentRepository.findByIdCustomerNumber(customerNumber).stream()
                .map(paymentModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(payments, linkTo(methodOn(PaymentController.class).getAllPaymentByCustomerNumber(customerNumber)).withSelfRel(),
                linkTo(methodOn(PaymentController.class).getAllPayment()).withRel("payment"));
    }


    @Override
    public CollectionModel<EntityModel<Payment>> getAllPayment() {
        List<EntityModel<Payment>> payments = paymentRepository.findAll().stream()
                .map(paymentModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(payments, linkTo(methodOn(PaymentController.class).getAllPayment()).withSelfRel());
    }
}
