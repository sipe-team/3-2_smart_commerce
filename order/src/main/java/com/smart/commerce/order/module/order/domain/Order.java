package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    Long id;

    OrderStatus orderStatus;

    UUID orderNumber;

    public OrderToPaymentEvent pay(ApplicationEventPublisher eventPublisher) {
        OrderToPaymentEvent event = new OrderToPaymentEvent(id, OrderStatus.PENDING_PAYMENT, orderNumber);
        eventPublisher.publishEvent(event);
        return event;
    }
}
