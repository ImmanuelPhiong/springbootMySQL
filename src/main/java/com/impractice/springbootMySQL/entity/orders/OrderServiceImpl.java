package com.impractice.springbootMySQL.entity.orders;

import com.impractice.springbootMySQL.entity.orders.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderModelAssembler orderModelAssembler;

    @Override
    public String createOrder(Order order) {
        orderRepository.save(order);
        return "Success";
    }

    @Override
    public String updateOrder(Order order) {
        orderRepository.save(order);
        return "Success";
    }

    @Override
    public String deleteOrder(Integer orderNumber) {
        orderRepository.deleteById(orderNumber);
        return "Success";

    }

    @Override
    public EntityModel<Order> getOrder(Integer orderNumber) {
        if(orderRepository.findById(orderNumber).isEmpty()){
            throw new OrderNotFoundException("Order with orderNumber: " + orderNumber + " is not exist");
        }
        Order order = orderRepository.findById(orderNumber).get();
        return orderModelAssembler.toModel(order);
    }

    @Override
    public CollectionModel<EntityModel<Order>> getAllOrder() {
        List<EntityModel<Order>> orders = orderRepository.findAll().stream()
                .map(orderModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(orders, linkTo(methodOn(OrderController.class).getAllOrder()).withSelfRel());

    }
}
