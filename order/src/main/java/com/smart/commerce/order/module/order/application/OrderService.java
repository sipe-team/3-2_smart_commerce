package com.smart.commerce.order.module.order.application;

import com.smart.commerce.order.module.order.event.OrderToPaymentEvent;
import com.smart.commerce.order.module.order.web.OrderRequest;

public interface OrderService {
    OrderToPaymentEvent orderToPayment(OrderRequest userId);
}
