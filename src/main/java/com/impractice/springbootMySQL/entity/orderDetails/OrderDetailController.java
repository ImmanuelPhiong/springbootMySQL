package com.impractice.springbootMySQL.entity.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping()
    public String createOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetailService.createOrderDetail(orderDetail);
        return "OrderDetail created successfully";
    }

    @PutMapping()
    public String updateOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailService.updateOrderDetail(orderDetail);
        return "OrderDetail updated successfully";
    }

    @DeleteMapping("/{orderNumber}/{productCode}")
    public String deleteOrderDetail(@PathVariable Integer orderNumber, @PathVariable String productCode){
        orderDetailService.deleteOrderDetail(new OrderDetailKey(orderNumber, productCode));
        return "OrderDetail deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<OrderDetail>> getAllOrderDetail(){
        return orderDetailService.getAllOrderDetail();
    }

    @GetMapping("/{orderNumber}")
    public CollectionModel<EntityModel<OrderDetail>> getOrderDetailByOrderNumber(@PathVariable Integer orderNumber){
        return orderDetailService.getOrderDetailByOrderNumber(orderNumber);
    }

    @GetMapping("/{orderNumber}/{productCode}")
    public EntityModel<OrderDetail> getOrderDetailPerItem(@PathVariable Integer orderNumber, @PathVariable String productCode){
        return orderDetailService.getOrderDetailPerItem(new OrderDetailKey(orderNumber, productCode));
    }
}
