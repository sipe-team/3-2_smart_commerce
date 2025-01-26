package com.smart.commerce.order.module.order.support.mapper;

import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;

public class OrderMapper {


    public static Order toInitDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(),
                orderEntity.getOrderStatus(),
                orderEntity.getOrderNumber(),
                orderEntity.getUserId(),
                orderEntity.getStorePrice() + orderEntity.getDeliveryPrice(),
                orderEntity.getStoreId(),
                orderEntity.getStorePrice(),
                orderEntity.getOrderType(),
                null,
                orderEntity.getDeliveryStatus(),
                0L,
                orderEntity.getCreatedAt(),
                orderEntity.getUpdatedAt()
        );
    }
}
