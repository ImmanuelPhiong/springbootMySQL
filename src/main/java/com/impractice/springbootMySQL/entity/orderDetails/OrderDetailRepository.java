package com.impractice.springbootMySQL.entity.orderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailKey> {
    List<OrderDetail> findByIdOrderNumber(Integer orderNumber);
    List<OrderDetail> findByIdProductCode(String productCode);
}
