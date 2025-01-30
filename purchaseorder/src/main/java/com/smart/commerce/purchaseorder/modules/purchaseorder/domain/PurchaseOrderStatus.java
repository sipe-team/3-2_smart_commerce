package com.smart.commerce.purchaseorder.modules.purchaseorder.domain;

public enum PurchaseOrderStatus {

    // 주문 관련 상태
    ORDER_RECEIVED("1000", "주문 접수", DeliveryType.COMMON, 1),

    // 조리 관련 상태
    ORDER_ACCEPTED("2001", "주문수락(조리중)", DeliveryType.COMMON, 2),
    ORDER_REJECTED("2002", "주문거절", DeliveryType.COMMON, -1),
    PREPARATION_COMPLETED("2003", "조리완료", DeliveryType.COMMON, 3),

    // 배달 관련 상태 (조리 완료 이후 배달로 분기)
    ASSIGNMENT_IN_PROGRESS("3001", "배차대기", DeliveryType.DELIVERY, 4),
    ASSIGNMENT_COMPLETED("3002", "배차완료", DeliveryType.DELIVERY, 5),
    DELIVERY_IN_PROGRESS("3003", "배달중(픽업완료)", DeliveryType.DELIVERY, 6),
    DELIVERY_COMPLETED("3004", "배달완료", DeliveryType.DELIVERY, 7),

    // 픽업 관련 상태 (조리 완료 이후 픽업으로 분기)
    WAITING_FOR_PICKUP("4001", "픽업대기", DeliveryType.PICKUP, 4),
    PICKUP_COMPLETED("4002", "픽업완료", DeliveryType.PICKUP, 5),

    // 정산 관련 상태
    SETTLEMENT_IN_PROGRESS("5001", "정산중", DeliveryType.COMMON, 8),
    SETTLEMENT_COMPLETED("5002", "정산완료", DeliveryType.COMMON, 9),

    // 취소 관련 상태
    ORDER_CANCELED("6001", "취소", DeliveryType.COMMON, -2);

    private final String code;
    private final String description;
    private final DeliveryType deliveryType;
    private final int sequence;

    PurchaseOrderStatus(String code, String description, DeliveryType deliveryType, int sequence) {
        this.code = code;
        this.description = description;
        this.deliveryType = deliveryType;
        this.sequence = sequence;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public int getSequence() {
        return sequence;
    }

    public PurchaseOrderStatus getNextStatus() {
        if (this == PREPARATION_COMPLETED) {
            return this.deliveryType == DeliveryType.DELIVERY ? ASSIGNMENT_IN_PROGRESS : WAITING_FOR_PICKUP;
        }
        for (PurchaseOrderStatus status : PurchaseOrderStatus.values()) {
            if (status.sequence == this.sequence + 1) {
                return status;
            }
        }
        return null;
    }
}