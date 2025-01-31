package com.smart.commerce.order.module.payment.domain.event;

public record ExternalPaymentEvent(
        String paymentId,
        boolean isSuccess
) {
}
