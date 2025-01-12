package com.smart.commerce.order.module.payment.applicatiojn;

import com.smart.commerce.order.module.order.event.OrderToPaymentEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentOrderListener {

    @ApplicationModuleListener
    public void handleOrderEvent(OrderToPaymentEvent event) {

    }
}
