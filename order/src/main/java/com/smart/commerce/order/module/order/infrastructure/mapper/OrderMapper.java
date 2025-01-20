package com.smart.commerce.order.module.order.infrastructure.mapper;

import com.smart.commerce.order.module.order.domain.model.Order;
import com.smart.commerce.order.module.order.entity.OrderEntity;

public class OrderMapper {


    public static Order toDomain(OrderEntity save) {
        return new Order();
    }

}
