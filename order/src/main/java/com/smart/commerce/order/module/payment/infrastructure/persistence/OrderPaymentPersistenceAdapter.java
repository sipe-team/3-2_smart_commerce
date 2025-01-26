package com.smart.commerce.order.module.payment.infrastructure.persistence;

import com.smart.commerce.order.module.payment.application.port.out.UpdateOrderPaymentPort;
import com.smart.commerce.order.module.payment.domain.OrderPayment;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentPersistenceAdapter implements UpdateOrderPaymentPort {

    private final OrderPaymentJpaRepository orderPaymentJpaRepository;

    public OrderPaymentPersistenceAdapter(OrderPaymentJpaRepository orderPaymentJpaRepository) {
        this.orderPaymentJpaRepository = orderPaymentJpaRepository;
    }

    @Override
    public void updateOrderPayment(OrderPayment orderPayment) {
        var savedEntity = orderPaymentJpaRepository.findByOrderNumber(orderPayment.getOrderNumber());
        if (savedEntity.isPresent()) {
            var entity = savedEntity.get();
            entity.update(orderPayment);
            orderPaymentJpaRepository.save(entity);
            return;
        }

        var entity = OrderPaymentEntity.create(orderPayment);
        orderPaymentJpaRepository.save(entity);
    }
}
