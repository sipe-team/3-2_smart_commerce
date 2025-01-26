package com.smart.commerce.order.module.payment.presentation.dto;

import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public record PayRequest(
        String orderNumber,
        PaymentProviderType providerType
) {
    public PayCommand toCommand(Long customerId) {
        return new PayCommand(customerId, orderNumber(), providerType());
    }
}
