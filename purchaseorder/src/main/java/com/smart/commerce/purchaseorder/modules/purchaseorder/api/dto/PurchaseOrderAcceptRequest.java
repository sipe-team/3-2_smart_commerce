package com.smart.commerce.purchaseorder.modules.purchaseorder.api.dto;

public record PurchaseOrderAcceptRequest(
        String userId,
        String storeId,
        String createdId
) {
    public PurchaseOrderAcceptCommand toCommand() {
        return new PurchaseOrderAcceptCommand(userId, storeId, createdId);
    }
}
