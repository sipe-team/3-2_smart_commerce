package com.smart.commerce.order.module.payment.application.dto;

public record PayProviderCommand(
        Long customerId,
        Long storeId,
        Long amount
) {
}