package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WaitingForPickupHandler implements StatusHandler {

    private static final Logger logger = LoggerFactory.getLogger(WaitingForPickupHandler.class);

    @Override
    public void handle(PurchaseOrderStatusChangedCommand command) {
        logger.info(" 픽업 대기중");
    }
}
