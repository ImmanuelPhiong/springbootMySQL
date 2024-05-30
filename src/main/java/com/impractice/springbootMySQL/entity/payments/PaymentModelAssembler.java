package com.impractice.springbootMySQL.entity.payments;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PaymentModelAssembler implements RepresentationModelAssembler<Payment, EntityModel<Payment>> {

    @Override
    public EntityModel<Payment> toModel(Payment payment) {
        return EntityModel.of(payment,
                linkTo(methodOn(PaymentController.class).getPayment
                        (payment.getId().getCustomerNumber(), payment.getId().getCheckNumber())).withSelfRel(),
                linkTo(methodOn(PaymentController.class).getAllPaymentByCustomerNumber
                                        (payment.getId().getCustomerNumber())).withRel("customerNumber"),
                linkTo(methodOn(PaymentController.class).getAllPayment()).withRel("payment"))
                ;
    }
}
