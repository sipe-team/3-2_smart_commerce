package com.smart.commerce.purchaseorder.modules.purchaseorder.infrastructure.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "purchase_order_history")
public class PurchaseOrderHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id; // 고유번호

    @Column(name = "PURCHASE_ORDER_ID", length = 20, nullable = false)
    private Long purchaseOrderId; // 주문번호 (UK)

    @Column(name = "STATUS", length = 20, nullable = false)
    private String status; // 상태 (UK)

    @Column(name = "CREATED_AT", nullable = false, columnDefinition = "TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 등록일

    @Column(name = "CREATED_ID", length = 100, nullable = false)
    private String createdId; // 등록자

    public Long getId() {
        return id;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PurchaseOrderHistoryEntity purchaseOrderHistoryEntity = (PurchaseOrderHistoryEntity) o;
        return Objects.equals(getId(), purchaseOrderHistoryEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
