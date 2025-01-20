package com.smart.commerce.order.module.order.domain.model;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEventPublisher;

public class Order {
    @Getter
    Long id;

    public OrderToPaymentEvent pay(ApplicationEventPublisher events) {
        OrderToPaymentEvent event = new OrderToPaymentEvent(id, OrderStatus.PENDING_PAYMENT);
        events.publishEvent(event);
        return event;
    }
}
