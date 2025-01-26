package com.smart.commerce.order.module.payment.infrastructure.persistence;

import com.smart.commerce.order.module.payment.domain.OrderPayment;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import com.smart.commerce.order.module.payment.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_payment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderPaymentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_number", unique = true)
    private String orderNumber;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "payment_provider_type")
    @Enumerated(EnumType.STRING)
    private PaymentProviderType paymentProviderType;

    @Column(name = "total_order_amount")
    private Long totalOrderAmount;

    @Column(name = "total_payed_amount")
    private Long totalPayedAmount;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "timestamp")
    private Long timestamp;

    public void update(OrderPayment payment) {
        this.paymentId = payment.getPaymentId();
        this.customerId = payment.getCustomerId();
        this.storeId = payment.getStoreId();
        this.paymentProviderType = payment.getPaymentType();
        this.totalOrderAmount = payment.getTotalOrderAmount();
        this.totalPayedAmount = payment.getTotalPayedAmount();
        this.paymentStatus = payment.getPaymentStatus();
    }

    public OrderPayment toDomain() {
        return new OrderPayment(
                orderNumber,
                paymentId,
                customerId,
                storeId,
                paymentProviderType,
                totalOrderAmount,
                totalPayedAmount,
                paymentStatus,
                timestamp
        );
    }

    static OrderPaymentEntity fromDomain(OrderPayment payment) {
        var newPayment = new OrderPaymentEntity();
        newPayment.orderNumber = payment.getOrderNumber();
        newPayment.paymentId = payment.getPaymentId();
        newPayment.customerId = payment.getCustomerId();
        newPayment.storeId = payment.getStoreId();
        newPayment.paymentProviderType = payment.getPaymentType();
        newPayment.totalOrderAmount = payment.getTotalOrderAmount();
        newPayment.totalPayedAmount = payment.getTotalPayedAmount();
        newPayment.paymentStatus = payment.getPaymentStatus();
        newPayment.timestamp = payment.getTimestamp();
        return newPayment;
    }
}
