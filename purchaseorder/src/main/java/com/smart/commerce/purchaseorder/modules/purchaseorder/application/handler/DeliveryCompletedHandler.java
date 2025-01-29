package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeliveryCompletedHandler implements StatusHandler {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryCompletedHandler.class);

    @Override
    public void handle(PurchaseOrderStatusChangedCommand command) {
        logger.info("✅ 배달완료");
    }
}
