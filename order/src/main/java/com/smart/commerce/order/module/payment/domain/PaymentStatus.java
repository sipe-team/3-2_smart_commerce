package com.smart.commerce.order.module.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PENDING("결제 대기"),
    COMPLETED("결제 완료"),
    CANCEL("결제 취소"),
    PAY_FAILED("결제 실패"),
    CANCEL_FAILED("결제 취소 실패"),
    UNKNOWN("알 수 없음"),
    ;

    private final String description;
}
