package com.smart.commerce.order.module.payment.application.service;

import com.smart.commerce.order.module.payment.application.dto.PayByOrderResult;
import com.smart.commerce.order.module.payment.application.dto.PayCommand;
import com.smart.commerce.order.module.payment.application.dto.PayProviderCommand;
import com.smart.commerce.order.module.payment.application.dto.PayProviderResult;
import com.smart.commerce.order.module.payment.application.port.in.PayUseCase;
import com.smart.commerce.order.module.payment.application.port.out.GetOrderPaymentPort;
import com.smart.commerce.order.module.payment.application.port.out.GetOrderPort;
import com.smart.commerce.order.module.payment.application.port.out.UpdateOrderPaymentPort;
import com.smart.commerce.order.module.payment.domain.OrderPayment;
import com.smart.commerce.order.module.payment.domain.PaymentProviderType;
import com.smart.commerce.order.module.payment.domain.event.OrderPaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService implements PayUseCase {

    private final PaymentProviderFactory paymentProviderFactory;
    private final GetOrderPort getOrderPort;
    private final GetOrderPaymentPort getOrderPaymentPort;
    private final UpdateOrderPaymentPort updateOrderPaymentPort;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void pay(PayCommand command) {
        validateOrderNumber(command.orderNumber());

        var orderInfo = fetchOrderInfo(command);

        var provider = paymentProviderFactory.getProvider(command.providerType());
        var payProviderCommand = new PayProviderCommand(
                orderInfo.customerId(),
                orderInfo.storeId(),
                orderInfo.totalPayedAmount()
        );
        var payProviderResult = provider.pay(payProviderCommand);

        var orderPayment = createOrderPayment(orderInfo, command.providerType(), payProviderResult);
        updateOrderPaymentPort.updateOrderPayment(orderPayment);

        var event = new OrderPaymentEvent(orderPayment.getOrderNumber(), orderPayment.getPaymentStatus());
        eventPublisher.publishEvent(event);
    }

    private void validateOrderNumber(String orderNumber) {
        if (orderNumber == null || orderNumber.isBlank()) {
            throw new IllegalArgumentException("주문번호는 필수입니다.");
        }

        var savedOrderPayment = getOrderPaymentPort.getOrderPayment(orderNumber);
        if (savedOrderPayment.isPresent()) {
            throw new IllegalStateException("이미 처리 진행 중이거나 완료된 주문입니다.");
        }
    }

    private void validateOrderInformation(PayCommand command, PayByOrderResult orderInfo) {
        if (orderInfo == null) {
            throw new IllegalStateException("주문 정보를 찾을 수 없습니다.");
        }

        if (orderInfo.orderNumber().isBlank() || orderInfo.customerId() == null || orderInfo.storeId() == null) {
            throw new IllegalStateException("주문 정보가 올바르지 않습니다.");
        }

        if (!orderInfo.orderNumber().equals(command.orderNumber())) {
            throw new IllegalStateException("주문 번호가 일치하지 않습니다.");
        }

        if (!orderInfo.customerId().equals(command.customerId())) {
            throw new IllegalStateException("결제 요청한 소비자 정보가 일치하지 않습니다.");
        }
    }

    private PayByOrderResult fetchOrderInfo(PayCommand command) {
        var orderInfo = getOrderPort.getOrder(command.orderNumber());
        validateOrderInformation(command, orderInfo);
        return orderInfo;
    }

    private OrderPayment createOrderPayment(
            PayByOrderResult orderInfo,
            PaymentProviderType providerType,
            PayProviderResult payProviderResult
    ) {
        if (payProviderResult.isSuccess()) {
            return OrderPayment.success(
                    orderInfo.orderNumber(),
                    payProviderResult.paymentId(),
                    orderInfo.customerId(),
                    orderInfo.storeId(),
                    providerType,
                    orderInfo.totalOrderAmount(),
                    orderInfo.totalPayedAmount()
            );
        }

        return OrderPayment.fail(
                orderInfo.orderNumber(),
                payProviderResult.paymentId(),
                orderInfo.customerId(),
                orderInfo.storeId(),
                providerType,
                orderInfo.totalOrderAmount(),
                orderInfo.totalPayedAmount()
        );
    }
}
