package com.smart.commerce.order.module.payment.application.service.strategy;

import com.smart.commerce.order.module.payment.application.dto.PayProviderCommand;
import com.smart.commerce.order.module.payment.application.dto.PayProviderResult;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public interface PaymentProvider {
    boolean isSupport(PaymentProviderType providerType);
    PayProviderResult pay(PayProviderCommand command);
}
