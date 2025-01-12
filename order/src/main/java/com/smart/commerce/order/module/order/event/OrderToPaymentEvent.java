package com.smart.commerce.order.module.order.event;

import com.smart.commerce.order.module.order.domain.OrderRecord;
import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.event.types.DomainEvent;

// TODO 필요한 값 설정 @희동
public record OrderToPaymentEvent(int orderId, OrderStatus orderStatus) implements DomainEvent {
}

