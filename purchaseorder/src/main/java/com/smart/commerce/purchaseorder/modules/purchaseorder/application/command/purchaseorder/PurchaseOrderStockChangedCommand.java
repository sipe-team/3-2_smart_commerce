package com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderStatus;

public record PurchaseOrderStockChangedCommand(
        Long id,
        String updatedId,
        PurchaseOrderStatus purchaseOrderStatus
) {
}
