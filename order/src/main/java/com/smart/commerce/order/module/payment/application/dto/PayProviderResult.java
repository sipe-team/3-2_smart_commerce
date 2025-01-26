package com.smart.commerce.order.module.payment.application.dto;

public record PayProviderResult(
        String paymentId,
        boolean isSuccess
) { }
