package com.smart.commerce.order.module.payment.infrastructure.listener;

import com.smart.commerce.order.module.payment.application.port.in.ProcessPayUseCase;
import com.smart.commerce.order.module.payment.domain.event.ExternalPaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
@RequiredArgsConstructor
public class FinTechDaemon {

    private final ProcessPayUseCase processPayUseCase;

    @Async
    @EventListener
    public void listen(ExternalPaymentEvent event) throws InterruptedException {
        Thread.sleep(1000);
        processPayUseCase.processPayment(event.paymentId(), event.isSuccess());
    }
}
