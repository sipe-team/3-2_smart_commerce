package com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;

public interface StatusHandler {
    void handle(PurchaseOrderStatusChangedCommand command);
}
