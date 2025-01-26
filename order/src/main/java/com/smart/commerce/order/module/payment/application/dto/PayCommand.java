package com.smart.commerce.order.module.payment.application.dto;

import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public record PayCommand(
        String orderNumber,
        PaymentProviderType providerType,
        Long totalOrderAmount,
        Long totalPayedAmount
) { }
