package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.delivery.PurchaseOrderDeliveryAssigned;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AssignmentInProgressHandler implements StatusHandler {

    private static final Logger logger = LoggerFactory.getLogger(AssignmentInProgressHandler.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    public AssignmentInProgressHandler(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void handle(PurchaseOrderStatusChangedCommand command) {
        logger.info("🚀 배차 대기 처리");
        applicationEventPublisher.publishEvent(new PurchaseOrderDeliveryAssigned(command.id()));
    }
}

