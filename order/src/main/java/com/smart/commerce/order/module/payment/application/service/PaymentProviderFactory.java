package com.smart.commerce.order.module.payment.application.service;

import com.smart.commerce.order.module.payment.application.service.strategy.PaymentProvider;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentProviderFactory {

    private final List<PaymentProvider> paymentProviders;

    @Autowired
    public PaymentProviderFactory(List<PaymentProvider> paymentProviders) {
        this.paymentProviders = paymentProviders;
    }

    public PaymentProvider getProvider(PaymentProviderType providerType) {
        return paymentProviders.stream()
                .filter(paymentProvider -> paymentProvider.isSupport(providerType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported payment type: " + providerType));
    }
}
