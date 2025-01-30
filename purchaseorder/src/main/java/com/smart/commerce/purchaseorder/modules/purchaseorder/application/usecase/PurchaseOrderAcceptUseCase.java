package com.smart.commerce.purchaseorder.modules.purchaseorder.application.usecase;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderInitialCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStockChangedCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrder;

public interface PurchaseOrderAcceptUseCase {
    PurchaseOrder processOrderRequest(final PurchaseOrderInitialCommand command);

    PurchaseOrder updateStatus(final PurchaseOrderStatusChangedCommand rejectCommand);

    PurchaseOrder updateStock(final PurchaseOrderStockChangedCommand changedCommand);

    PurchaseOrder requestRiderAssignment(final PurchaseOrderStatusChangedCommand changedCommand);
}
