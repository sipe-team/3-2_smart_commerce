package com.smart.commerce.order.module.payment.presentation.dto;

import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public record PayRequest(
        String orderNumber,
        PaymentProviderType providerType
) { }
