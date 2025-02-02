package com.smart.commerce.order.module.order.infrastructure.repository;

import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


// TODO JPA 연동 이후 변경 예정
@Component
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    Order findByOrderNumber(UUID uuid);
}
