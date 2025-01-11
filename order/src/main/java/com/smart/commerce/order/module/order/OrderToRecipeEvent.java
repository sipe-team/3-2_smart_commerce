package com.smart.commerce.order.module.order;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.event.types.DomainEvent;

@ValueObject
public record OrderToRecipeEvent(Order orderId) implements DomainEvent {
}
