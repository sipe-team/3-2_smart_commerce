package com.smart.commerce.order.module.payment.application.dto;

public record Wilump(
        String orderNumber,
        Long totalOrderAmount,
        Long totalPayedAmount
) { }