package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AssignmentCompletedHandler implements StatusHandler {

    private static final Logger logger = LoggerFactory.getLogger(AssignmentCompletedHandler.class);

    @Override
    public void handle(PurchaseOrderStatusChangedCommand command) {
        logger.info("✅ 배차 완료 후 라이더 배정");
    }
}
