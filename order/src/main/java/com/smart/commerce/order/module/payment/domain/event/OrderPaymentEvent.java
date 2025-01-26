package com.smart.commerce.order.module.payment.domain.event;

import com.smart.commerce.order.module.payment.domain.PaymentStatus;

public record OrderPaymentEvent(
        String orderNumber,
        PaymentStatus paymentStatus
) { }
