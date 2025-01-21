package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;


    public static OrderEntity create(Long userId) {
        return new OrderEntity(null, userId);
    }
}
