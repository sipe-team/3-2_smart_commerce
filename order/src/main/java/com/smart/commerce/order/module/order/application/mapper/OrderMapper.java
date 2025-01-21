package com.smart.commerce.order.module.order.application.mapper;

import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;

public class OrderMapper {


    public static Order toDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId());
    }

}
