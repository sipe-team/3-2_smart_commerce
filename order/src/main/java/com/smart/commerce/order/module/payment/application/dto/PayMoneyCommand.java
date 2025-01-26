package com.smart.commerce.order.module.payment.application.dto;

import com.smart.commerce.order.module.payment.domain.PaymentProviderType;

public record PayMoneyCommand(
        Long orderId,
        Long customerId,
        Long membershipId,
        Long totalOrderAmount,
        Long totalPayedAmount,
        PaymentProviderType provider
) {}
