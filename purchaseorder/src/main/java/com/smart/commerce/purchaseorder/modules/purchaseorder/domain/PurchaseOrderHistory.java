package com.smart.commerce.purchaseorder.modules.purchaseorder.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class PurchaseOrderHistory {

    private Long id;
    private Long purchaseOrderId;
    private PurchaseOrderStatus status;
    private LocalDateTime createdAt;
    private String createdId;

    public static PurchaseOrderHistory initialize(
            Long purchaseOrderId,
            PurchaseOrderStatus status,
            String createdId
    ) {
        return new PurchaseOrderHistory(
                purchaseOrderId,
                status,
                createdId
        );
    }

    public PurchaseOrderHistory(Long purchaseOrderId, PurchaseOrderStatus status, String createdId) {
        this.purchaseOrderId = purchaseOrderId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.createdId = createdId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PurchaseOrderHistory purchaseOrder = (PurchaseOrderHistory) o;
        return Objects.equals(getId(), purchaseOrder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
