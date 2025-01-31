package com.smart.commerce.order.module.order.infrastructure.listener.event;

import com.smart.commerce.order.module.order.infrastructure.repository.entity.OrderStatus;
import org.jmolecules.event.types.DomainEvent;

// TODO To Owner module @우재
public record OrderToStoreEvent(OrderStatus orderStatus) implements DomainEvent {
}
