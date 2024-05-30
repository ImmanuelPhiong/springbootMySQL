package com.impractice.springbootMySQL.entity.orders;

import com.impractice.springbootMySQL.entity.customers.CustomerController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {
        return EntityModel.of(order,
                linkTo(methodOn(OrderController.class).getOrder(order.getOrderNumber())).withSelfRel(),
                linkTo(methodOn(OrderController.class).getAllOrder()).withRel("order"),
                linkTo(methodOn(CustomerController.class).getCustomer(order.getCustomerNumber().getCustomerNumber()))
                        .withRel("customer"));
    }
}
