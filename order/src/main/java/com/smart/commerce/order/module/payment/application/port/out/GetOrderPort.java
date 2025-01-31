package com.smart.commerce.order.module.payment.application.port.out;

import com.smart.commerce.order.module.payment.application.dto.PayByOrderResult;

public interface GetOrderPort {
    PayByOrderResult getOrder(String orderNumber);
}
