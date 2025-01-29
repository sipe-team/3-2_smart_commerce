package com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderStatus;

public record PurchaseOrderInitialCommand(
        String userId,
        String storeId,
        String modifiedBy,
        PurchaseOrderStatus status
) {
}
