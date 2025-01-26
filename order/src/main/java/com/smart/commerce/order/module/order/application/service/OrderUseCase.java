package com.smart.commerce.order.module.order.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.port.ShoppingCartPort;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderUseCase {
    private final ApplicationEventPublisher eventPublisher;
    private final ShoppingCartPort shoppingCartPort;
    private final OrderRepository orderRepository;

    public OrderUseCase(ApplicationEventPublisher eventPublisher, ShoppingCartPort shoppingCartPort, OrderRepository orderRepository) {
        this.eventPublisher = eventPublisher;
        this.shoppingCartPort = shoppingCartPort;
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Transactional
    public Order orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartPort.getItems(orderRequest.userId());
        Order order = orderRepository.save(shoppingCart, orderRequest);
        order.pay(eventPublisher);
        return order;
    }


}
