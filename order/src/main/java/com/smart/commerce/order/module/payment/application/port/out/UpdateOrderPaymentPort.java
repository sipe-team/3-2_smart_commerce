package com.smart.commerce.order.module.payment.application.port.out;

import com.smart.commerce.order.module.payment.domain.OrderPayment;

public interface UpdateOrderPaymentPort {
    void updateOrderPayment(OrderPayment orderPayment);
}
