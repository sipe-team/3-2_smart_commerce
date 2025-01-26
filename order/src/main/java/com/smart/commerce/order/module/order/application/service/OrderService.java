package com.smart.commerce.order.module.order.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.application.port.out.ShoppingCartPort;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final ShoppingCartPort shoppingCartPort;
    private final OrderRepository orderRepository;
    public OrderService(ShoppingCartPort shoppingCartPort, OrderRepository orderRepository) {
        this.shoppingCartPort = shoppingCartPort;
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Transactional
    public Order orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartPort.getItems(orderRequest.customerId());

        Order order = orderRepository.save(shoppingCart, orderRequest);
        return order;
    }


    public Order getOrderByOrderNumber(String orderNumber) {
        return orderRepository.getOrderByOrderNumber(orderNumber);
    }
}
