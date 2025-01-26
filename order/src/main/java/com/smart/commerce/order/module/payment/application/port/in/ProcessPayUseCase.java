package com.smart.commerce.order.module.payment.application.port.in;

public interface ProcessPayUseCase {
    void processPayment(String paymentId, boolean isSuccess);
}
