package com.smart.commerce.order.module.order.event;

import com.smart.commerce.order.module.order.domain.OrderRecord;
import org.jmolecules.event.types.DomainEvent;

// TODO To Owner module @우재
public record OrderToStoreEvent(OrderStatus orderStatus) implements DomainEvent {
}
