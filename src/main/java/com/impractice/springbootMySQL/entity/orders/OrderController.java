package com.impractice.springbootMySQL.entity.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public String createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return "Order created successfully";
    }

    @PutMapping()
    public String updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
        return "Order updated successfully";
    }

    @DeleteMapping("/{orderNumber}")
    public String deleteOrder(@PathVariable Integer orderNumber){
        orderService.deleteOrder(orderNumber);
        return "Order deleted successfully";
    }

    @GetMapping()
    public CollectionModel<EntityModel<Order>> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{orderNumber}")
    public EntityModel<Order> getOrder(@PathVariable Integer orderNumber){
        return orderService.getOrder(orderNumber);
    }
}
