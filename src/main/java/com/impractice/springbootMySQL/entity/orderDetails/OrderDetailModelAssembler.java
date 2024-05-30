package com.impractice.springbootMySQL.entity.orderDetails;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderDetailModelAssembler implements RepresentationModelAssembler<OrderDetail, EntityModel<OrderDetail>> {
    @Override
    public EntityModel<OrderDetail> toModel(OrderDetail orderDetail) {
        return EntityModel.of(orderDetail,
                linkTo(methodOn(OrderDetailController.class).getOrderDetailPerItem
                        (orderDetail.getId().getOrderNumber(), orderDetail.getId().getProductCode())).withSelfRel(),
                linkTo(methodOn(OrderDetailController.class).getOrderDetailByOrderNumber
                        (orderDetail.getId().getOrderNumber())).withRel("orderNumber"),
                linkTo(methodOn(OrderDetailController.class).getAllOrderDetail()).withRel("orderDetail"))
                ;
    }
}
