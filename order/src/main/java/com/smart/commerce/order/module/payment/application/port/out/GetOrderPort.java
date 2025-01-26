package com.smart.commerce.order.module.payment.application.port.out;

import com.smart.commerce.order.module.payment.application.dto.Wilump;

public interface GetOrderPort {
    Wilump getOrder(String orderNumber);
}
