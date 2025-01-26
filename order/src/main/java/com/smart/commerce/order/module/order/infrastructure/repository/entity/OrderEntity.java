package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "order_type")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

//    TODO 배달 정보 연동
//    @JoinColumn(name = "order_delivery_id")
//    @OneToOne(optional = true)
//    private OrderDeliveryEntity orderDeliveryEntity;

    @Column(name = "store_price")
    private Long storePrice;

    @Column(name = "delivery_price")
    private Long deliveryPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "delivery_status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "order_number")
    private UUID orderNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
