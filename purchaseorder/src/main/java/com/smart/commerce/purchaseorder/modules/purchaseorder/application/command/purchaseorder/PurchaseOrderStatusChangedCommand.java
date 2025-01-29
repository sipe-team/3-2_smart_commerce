package com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder;

import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.DeliveryType;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.PurchaseOrderStatus;

public record PurchaseOrderStatusChangedCommand(
        Long id,                    // 주문서 ID
        String modifiedBy,          // 명령자
        DeliveryType deliveryType,  // 배달 타입 (DELIVERY, PICKUP)
        PurchaseOrderStatus status  // 현재 상태 값
) {

    public PurchaseOrderStatusChangedCommand withStatus(PurchaseOrderStatus newStatus) {
        return new PurchaseOrderStatusChangedCommand(this.id, this.modifiedBy, this.deliveryType, newStatus);
    }

}
