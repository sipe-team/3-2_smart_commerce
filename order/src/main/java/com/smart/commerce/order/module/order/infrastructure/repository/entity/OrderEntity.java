package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long storeId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private UUID orderNumber;

    public static OrderEntity create(Long userId, Long storeId, UUID orderNumber) {
        return new OrderEntity(null, userId, storeId, OrderStatus.PENDING_PAYMENT, orderNumber);
    }
}
