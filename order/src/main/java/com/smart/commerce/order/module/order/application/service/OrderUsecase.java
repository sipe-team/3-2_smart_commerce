package com.smart.commerce.order.module.order.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.mapper.OrderMapper;
import com.smart.commerce.order.module.order.application.port.ShoppingCartPort;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
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
    public Order orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartPort.getItems(orderRequest.userId());
        Order order = OrderMapper.toDomain(orderRepository.save(shoppingCart, orderRequest));
        order.pay(eventPublisher);
        return order;
    }
}
