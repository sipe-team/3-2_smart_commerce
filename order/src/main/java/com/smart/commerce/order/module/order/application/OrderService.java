package com.smart.commerce.order.module.order.application;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import com.smart.commerce.order.module.order.infrastructure.OrderRequest;

public interface OrderService {
    OrderToPaymentEvent orderToPayment(OrderRequest userId);
}
