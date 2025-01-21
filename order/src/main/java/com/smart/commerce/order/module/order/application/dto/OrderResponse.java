package com.smart.commerce.order.module.order.application.dto;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderResponse(UUID orderNumber, OrderStatus orderStatus) {
}
