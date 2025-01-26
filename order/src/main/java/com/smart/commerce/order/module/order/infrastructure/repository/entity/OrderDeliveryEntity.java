package com.smart.commerce.order.module.order.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "order_delivery")
@Entity
public class OrderDeliveryEntity {

    @Id
    // Foreign key
    Long orderId;

    Long deliverId;

    Long deliverCompanyId;
}
