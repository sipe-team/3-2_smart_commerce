package com.smart.commerce.purchaseorder.modules.purchaseorder.application.service;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler.*;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StatusHandlerRegistry {
    private final Map<PurchaseOrderStatus, StatusHandler> handlers = new HashMap<>();

    @Autowired
    public StatusHandlerRegistry(List<StatusHandler> handlerList) {
        for (StatusHandler handler : handlerList) {
            if (handler instanceof PreparationCompletedHandler) {
                handlers.put(PurchaseOrderStatus.PREPARATION_COMPLETED, handler);
            } else if (handler instanceof AssignmentInProgressHandler) {
                handlers.put(PurchaseOrderStatus.ASSIGNMENT_IN_PROGRESS, handler);
            } else if (handler instanceof AssignmentCompletedHandler) {
                handlers.put(PurchaseOrderStatus.ASSIGNMENT_COMPLETED, handler);
            } else if (handler instanceof DeliveryInProgressHandler) {
                handlers.put(PurchaseOrderStatus.DELIVERY_IN_PROGRESS, handler);
            } else if (handler instanceof DeliveryCompletedHandler) {
                handlers.put(PurchaseOrderStatus.DELIVERY_COMPLETED, handler);
            } else if (handler instanceof WaitingForPickupHandler) {
                handlers.put(PurchaseOrderStatus.WAITING_FOR_PICKUP, handler);
            } else if (handler instanceof PickupCompletedHandler) {
                handlers.put(PurchaseOrderStatus.PICKUP_COMPLETED, handler);
            } else if (handler instanceof OrderCanceledHandler) {
                handlers.put(PurchaseOrderStatus.ORDER_CANCELED, handler);
            }
        }
    }

    public StatusHandler getHandler(PurchaseOrderStatus status) {
        return handlers.getOrDefault(status, command -> {
            throw new IllegalArgumentException("지원되지 않는 상태: " + status);
        });
    }
}
