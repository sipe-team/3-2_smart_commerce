package com.smart.commerce.order.module.payment.application.port.out;

import com.smart.commerce.order.module.payment.domain.OrderPayment;

import java.util.Optional;

public interface GetOrderPaymentPort {
    Optional<OrderPayment> getOrderPayment(String orderNumber);
}
