package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.delivery.PurchaseOrderDeliveryAssigned;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PreparationCompletedHandler implements StatusHandler {

    private static final Logger logger = LoggerFactory.getLogger(PreparationCompletedHandler.class);

    @Override
    public void handle(PurchaseOrderStatusChangedCommand command) {
        logger.info("🌮 조리완료");
    }
}
