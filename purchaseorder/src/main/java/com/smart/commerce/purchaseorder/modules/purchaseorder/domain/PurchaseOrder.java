package com.smart.commerce.purchaseorder.modules.purchaseorder.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

public class PurchaseOrder {

    private Long id;
    private String userId;
    private String storeId;
    private PurchaseOrderStatus status;
    private LocalDateTime createdAt;
    private String createdId;
    private LocalDateTime updatedAt;
    private String updatedId;

    public PurchaseOrder() {
    }

    public static PurchaseOrder initialize(
            String userId,
            String storeId,
            PurchaseOrderStatus status,
            String createdId
    ) {
        return new PurchaseOrder(
                userId,
                storeId,
                status,
                LocalDateTime.now(),
                createdId,
                LocalDateTime.now()
        );
    }

    public PurchaseOrder(Long id, String userId, String storeId, PurchaseOrderStatus status, LocalDateTime createdAt, String createdId, LocalDateTime updatedAt, String updatedId) {
        this.id = id;
        this.userId = userId;
        this.storeId = storeId;
        this.status = status;
        this.createdAt = createdAt;
        this.createdId = createdId;
        this.updatedAt = updatedAt;
        this.updatedId = updatedId;
    }

    public PurchaseOrder(String userId, String storeId, PurchaseOrderStatus status, LocalDateTime createdAt, String createdId, LocalDateTime updatedAt) {
        this.userId = userId;
        this.storeId = storeId;
        this.status = status;
        this.createdAt = createdAt;
        this.createdId = createdId;
        this.updatedAt = updatedAt;
    }

    public PurchaseOrder(Long id, PurchaseOrderStatus status, String updatedId) {
        this.id = id;
        this.status = status;
        this.updatedAt = LocalDateTime.now();
        this.updatedId = updatedId;
    }

    //    public PurchaseOrder registerCbr(final com.smart.commerce.ceo.modules.ceo.domain.Cbr cbr) {
//        return new PurchaseOrder(id, account, password, name, birth, phoneNumber, email, cbr, cbo);
//    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public PurchaseOrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedId() {
        return createdId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedId() {
        return updatedId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PurchaseOrder purchaseOrder = (PurchaseOrder) o;
        return Objects.equals(getId(), purchaseOrder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
