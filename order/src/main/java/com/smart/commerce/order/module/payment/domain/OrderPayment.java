package com.smart.commerce.order.module.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  결제
 * - 주문 등록과 동시에 결제를 진행해야 한다
 * - 결제 금액은 주문 금액과 일치해야 한다
 * - 결제 성공 시 주문 상태가 ‘결제 완료’로 변경된다
 * - 결제 실패 시 주문 상태가 ‘결제 실패’로 변경된다
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPayment {
    private String orderNumber;
    private String paymentId;
    private Long customerId;
    private Long storeId;
    private PaymentProviderType paymentType;
    private Long totalOrderAmount;
    private Long totalPayedAmount;
    private PaymentStatus paymentStatus;
    private Long timestamp;

    public void success() {
        this.paymentStatus = PaymentStatus.COMPLETED;
    }

    public void failed() {
        this.paymentStatus = PaymentStatus.PAY_FAILED;
    }

    public boolean isPayFailed() {
        return this.paymentStatus == PaymentStatus.PAY_FAILED;
    }

    public static OrderPayment createPendingPayment(
            String orderNumber,
            String paymentId,
            Long customerId,
            Long storeId,
            PaymentProviderType paymentType,
            Long totalOrderAmount,
            Long totalPayedAmount
    ) {
        return new OrderPayment(
                orderNumber,
                paymentId,
                customerId,
                storeId,
                paymentType,
                totalOrderAmount,
                totalPayedAmount,
                PaymentStatus.PENDING,
                System.currentTimeMillis()
        );
    }

    public static OrderPayment createFailedPayment(
            String orderNumber,
            String paymentId,
            Long customerId,
            Long storeId,
            PaymentProviderType paymentType,
            Long totalOrderAmount,
            Long totalPayedAmount
    ) {
        return new OrderPayment(
                orderNumber,
                paymentId,
                customerId,
                storeId,
                paymentType,
                totalOrderAmount,
                totalPayedAmount,
                PaymentStatus.PAY_FAILED,
                System.currentTimeMillis()
        );
    }
}
