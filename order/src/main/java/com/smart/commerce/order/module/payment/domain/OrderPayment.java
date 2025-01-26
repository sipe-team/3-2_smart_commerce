package com.smart.commerce.order.module.payment.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  결제
 * - 주문 등록과 동시에 결제를 진행해야 한다
 * - 결제 금액은 주문 금액과 일치해야 한다
 * - 결제 성공 시 주문 상태가 ‘결제 완료’로 변경된다
 * - 결제 실패 시 주문 상태가 ‘결제 실패’로 변경된다
 */

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderPayment {
    private String orderNumber;
    private String paymentId;
    private PaymentProviderType paymentType;
    private Long totalOrderAmount;
    private Long totalPayedAmount;
    private PaymentStatus paymentStatus;
}
