package com.smart.commerce.order.module.payment.application.dto;

import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public record PayCommand(
        Long customerId,
        String orderNumber,
        PaymentProviderType providerType
) { }
