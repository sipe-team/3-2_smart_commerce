package com.smart.commerce.purchaseorder.modules.purchaseorder.domain;

public interface PurchaseOrderRepository {
    PurchaseOrder save(final PurchaseOrder purchaseOrder);
    PurchaseOrder updateStatus(final PurchaseOrder purchaseOrder);
}
