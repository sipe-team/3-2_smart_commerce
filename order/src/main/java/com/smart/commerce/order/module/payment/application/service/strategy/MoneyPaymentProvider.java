package com.smart.commerce.order.module.payment.application.service.strategy;

import com.smart.commerce.order.module.payment.application.dto.PayProviderCommand;
import com.smart.commerce.order.module.payment.application.dto.PayProviderResult;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import org.springframework.stereotype.Component;

import static com.smart.commerce.order.module.payment.domain.PaymentProviderType.MONEY;

@Component
public class MoneyPaymentProvider implements PaymentProvider {

    @Override
    public boolean isSupport(PaymentProviderType providerType) {
        return MONEY.equals(providerType);
    }

    @Override
    public PayProviderResult pay(PayProviderCommand command) {
        return null;
    }
}