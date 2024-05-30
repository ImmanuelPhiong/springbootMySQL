package com.impractice.springbootMySQL.entity.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping()
    public String createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        return "Payment created successfully";
    }

    @PutMapping()
    public String updatePayment(@RequestBody Payment payment){
        paymentService.updatePayment(payment);
        return "Payment updated successfully";
    }

    @DeleteMapping("/{customerNumber}/{checkNumber}")
    public String deleteCustomer(@PathVariable Integer customerNumber, @PathVariable String checkNumber){
        paymentService.deletePayment(new PaymentKey(customerNumber, checkNumber));
        return "Customer deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Payment>> getAllPayment(){
        return paymentService.getAllPayment();
    }

    @GetMapping("/{customerNumber}")
    public CollectionModel<EntityModel<Payment>> getAllPaymentByCustomerNumber(@PathVariable Integer customerNumber) {
        return paymentService.getPaymentbyCustomerNumber(customerNumber);
    }

    @GetMapping("/{customerNumber}/{checkNumber}")
    public EntityModel<Payment> getPayment(@PathVariable Integer customerNumber, @PathVariable String checkNumber){
        return paymentService.getPayment(new PaymentKey(customerNumber, checkNumber));
    }
}
