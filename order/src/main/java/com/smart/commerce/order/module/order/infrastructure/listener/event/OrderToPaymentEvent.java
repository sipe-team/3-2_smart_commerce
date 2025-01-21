package com.smart.commerce.order.module.order.infrastructure.listener.event;


import java.util.UUID;

// TODO 필요한 값 설정 @희동
public record OrderToPaymentEvent(Long orderId,
                                  OrderStatus orderStatus,
                                  UUID orderNumber) {
}

