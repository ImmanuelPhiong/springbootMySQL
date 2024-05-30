package com.impractice.springbootMySQL.entity.orderDetails;

import com.impractice.springbootMySQL.entity.orderDetails.exception.OrderDetailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderDetailModelAssembler orderDetailModelAssembler;

    @Override
    public String createOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return "Success";
    }

    @Override
    public String updateOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return "Success";
    }

    @Override
    public String deleteOrderDetail(OrderDetailKey orderDetailKey) {
        orderDetailRepository.deleteById(orderDetailKey);
        return "Success";
    }

    @Override
    public EntityModel<OrderDetail> getOrderDetailPerItem(OrderDetailKey orderDetailKey) {
        if(orderDetailRepository.findById(orderDetailKey).isEmpty()){
            throw new OrderDetailNotFoundException("OrderDetail with OrderNumber: " + orderDetailKey.getOrderNumber() +
                    " and ProductCode: " + orderDetailKey.getProductCode() +" is not exist");
        }
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailKey).get();
        return orderDetailModelAssembler.toModel(orderDetail);
    }

    @Override
    public CollectionModel<EntityModel<OrderDetail>> getOrderDetailByOrderNumber(Integer orderNumber) {
        if(orderDetailRepository.findByIdOrderNumber(orderNumber).isEmpty()){
            throw new OrderDetailNotFoundException("OrderDetail with OrderNumber: " + orderNumber + " is not exist");
        }
        List<EntityModel<OrderDetail>> orderDetails = orderDetailRepository.findByIdOrderNumber(orderNumber).stream()
                .map(orderDetailModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(orderDetails, linkTo(methodOn(OrderDetailController.class).getOrderDetailByOrderNumber(orderNumber)).withSelfRel(),
                linkTo(methodOn(OrderDetailController.class).getAllOrderDetail()).withRel("orderDetail"));
    }

    @Override
    public CollectionModel<EntityModel<OrderDetail>> getAllOrderDetail() {
        List<EntityModel<OrderDetail>> orderDetails = orderDetailRepository.findAll().stream()
                .map(orderDetailModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(orderDetails, linkTo(methodOn(OrderDetailController.class).getAllOrderDetail()).withSelfRel());
    }
}
