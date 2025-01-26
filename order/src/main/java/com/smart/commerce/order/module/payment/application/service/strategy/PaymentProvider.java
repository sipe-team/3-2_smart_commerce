package com.smart.commerce.order.module.payment.application.service.strategy;

import com.smart.commerce.order.module.payment.application.dto.PayResult;
import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public interface PaymentProvider {
    boolean isSupport(PaymentProviderType providerType);
    PayResult pay(PayCommand command);
}
