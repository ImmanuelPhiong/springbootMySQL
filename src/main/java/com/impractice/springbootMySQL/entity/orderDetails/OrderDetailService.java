package com.impractice.springbootMySQL.entity.orderDetails;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface OrderDetailService {
    public String createOrderDetail(OrderDetail orderDetail);
    public String updateOrderDetail(OrderDetail orderDetail);
    public String deleteOrderDetail(OrderDetailKey orderDetailKey);
    public EntityModel<OrderDetail> getOrderDetailPerItem(OrderDetailKey orderDetailKey);
    public CollectionModel<EntityModel<OrderDetail>> getOrderDetailByOrderNumber(Integer orderNumber);
    public CollectionModel<EntityModel<OrderDetail>> getAllOrderDetail();
}
