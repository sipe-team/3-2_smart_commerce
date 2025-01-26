package com.smart.commerce.order.module.order.support.factory;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.DeliveryStatus;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderEntity;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderType;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderFactory {

    public static OrderEntity createEntityInitBeforeDelivery(ShoppingCart shoppingCart, long userId, long storeId, UUID orderNumber, OrderType orderType) {
        return new OrderEntity(null,
                userId,
                shoppingCart.storeId(),
                shoppingCart.storePrice(),// Total price
                orderType,
                shoppingCart.storePrice(),
                0L,
                OrderStatus.PENDING_PAYMENT,
                DeliveryStatus.BEFORE_PAYMENT,
                orderNumber,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }


}
