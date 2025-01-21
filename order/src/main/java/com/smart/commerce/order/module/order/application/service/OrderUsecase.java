package com.smart.commerce.order.module.order.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.ShoppingCartPort;

import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;

import com.smart.commerce.order.module.order.infrastructure.mapper.OrderMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderUsecase {
    private final ApplicationEventPublisher eventPublisher;
    private final ShoppingCartPort shoppingCartPort;
    private final OrderRepository orderRepository;

    public OrderUsecase(ApplicationEventPublisher eventPublisher, ShoppingCartPort shoppingCartPort, OrderRepository orderRepository) {
        this.eventPublisher = eventPublisher;
        this.shoppingCartPort = shoppingCartPort;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderToPaymentEvent orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartPort.getItems(orderRequest.userId());
        orderRepository.save(shoppingCart, orderRequest);
        Order order = OrderMapper.toDomain(orderRepository.save(shoppingCart, orderRequest));
        return order.pay(eventPublisher);
    }

    private Order saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest) {
//        order.checkOrderValid(shoppingCart, orderRequest);
//        int orderId = 1; // TODO test order id
        return null;
    }
}
