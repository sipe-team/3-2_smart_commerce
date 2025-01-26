package com.smart.commerce.order.module.payment.application.dto;

public record PayByOrderResult(
        String orderNumber,
        Long totalOrderAmount,
        Long totalPayedAmount,
        Long customerId,
        Long storeId
) { }