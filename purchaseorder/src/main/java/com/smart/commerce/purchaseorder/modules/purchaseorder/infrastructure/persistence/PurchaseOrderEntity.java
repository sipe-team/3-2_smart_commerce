package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "purchase-order")
@Entity
public class PurchaseOrderEntity {

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    @Comment("고유번호")
    private Long id; // 고유번호

    @Column(name = "USER_ID", nullable = false, length = 100)
    @Comment("주문자")
    private String userId; // 주문자

    @Column(name = "STORE_ID", nullable = false, length = 100)
    @Comment("가게코드")
    private String storeId; // 가게코드

    @Column(name = "DELIVERY_TYPE", nullable = false, length = 10)
    @Comment("주문형태(DELIVERY, PICKUP)")
    private String deliveryType; // 가게코드

    @Column(name = "STATUS", nullable = false, length = 10)
    @Comment("상태")
    @Enumerated
    private PurchaseOrderStatus status; // 상태

    @Column(name = "CREATED_AT", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("등록일")
    private LocalDateTime createdAt = LocalDateTime.now(); // 등록일

    @Column(name = "CREATED_ID", nullable = false, length = 100)
    @Comment("등록자")
    private String createdId; // 등록자

    @Column(name = "UPDATED_AT", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Comment("수정일")
    private LocalDateTime updatedAt = LocalDateTime.now(); // 수정일

    @Column(name = "UPDATED_ID", length = 100)
    @Comment("수정자")
    private String updatedId; // 수정자

    public PurchaseOrderEntity(Long id, String userId, String storeId, PurchaseOrderStatus status, String createdId) {
        this.id = id;
        this.userId = userId;
        this.storeId = storeId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.createdId = createdId;
        this.updatedAt = LocalDateTime.now();
    }

    public PurchaseOrderEntity(String userId, String storeId, PurchaseOrderStatus status, String createdId) {
        this.userId = userId;
        this.storeId = storeId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.createdId = createdId;
        this.updatedAt = LocalDateTime.now();
    }

    public PurchaseOrderEntity(String userId, String storeId, PurchaseOrderStatus status, LocalDateTime createdAt, String createdId, LocalDateTime updatedAt, String updatedId) {
        this.userId = userId;
        this.storeId = storeId;
        this.status = status;
        this.createdAt = createdAt;
        this.createdId = createdId;
        this.updatedAt = updatedAt;
        this.updatedId = updatedId;
    }

    public PurchaseOrderEntity() {}

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getDeliveryType() {
        return deliveryType;
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

    public void updateStatus(PurchaseOrderStatus status) {
        this.status = status;
    }

    public void updateUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void updateUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PurchaseOrderEntity purchaseOrderEntity = (PurchaseOrderEntity) o;
        return Objects.equals(getId(), purchaseOrderEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
