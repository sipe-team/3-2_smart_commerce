package com.smart.commerce.order.module.order.infrastructure.listener;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentCompleteEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentEventListener {
    // TODO Payment 완료 EVNET로 매개변수 변경
    @ApplicationModuleListener
    public void handleOrderEvent(OrderToPaymentCompleteEvent event) {

    }
}
