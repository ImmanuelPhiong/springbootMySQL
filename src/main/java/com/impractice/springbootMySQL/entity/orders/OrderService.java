package com.impractice.springbootMySQL.entity.orders;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface OrderService {
    public String createOrder(Order order);
    public String updateOrder(Order order);
    public String deleteOrder(Integer orderNumber);
    public EntityModel<Order> getOrder(Integer orderNumber);
    public CollectionModel<EntityModel<Order>> getAllOrder();
}
