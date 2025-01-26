package com.smart.commerce.order.module.payment.application.port.in;

import com.smart.commerce.order.module.payment.application.dto.PayCommand;

public interface PayUseCase {
    void pay(PayCommand command);
}
