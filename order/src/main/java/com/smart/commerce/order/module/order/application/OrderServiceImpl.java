package com.smart.commerce.order.module.order.application;

import com.smart.commerce.order.module.cart.ShoppingCartService;
import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.domain.Order;
import com.smart.commerce.order.module.order.domain.OrderRecord;
import com.smart.commerce.order.module.order.domain.OrderRepository;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.event.OrderStatus;
import com.smart.commerce.order.module.order.event.OrderToPaymentEvent;
import com.smart.commerce.order.module.order.web.OrderRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final ApplicationEventPublisher events;
    private final ShoppingCartService shoppingCartService;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderToPaymentEvent orderToPayment(OrderRequest orderRequest) {
        ShoppingCart shoppingCart = shoppingCartService.getItems(orderRequest.userId());
        OrderRecord orderRecord = saveOrder(shoppingCart, orderRequest);
        OrderToPaymentEvent orderToPaymentEvent = new OrderToPaymentEvent(orderRecord.orderId(), OrderStatus.PENDING_PAYMENT);
        events.publishEvent(orderToPaymentEvent);
        return orderToPaymentEvent;
    }

    private OrderRecord saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest) {
//        order.checkOrderValid(shoppingCart, orderRequest);
//        int orderId = 1; // TODO test order id
        OrderEntity orderEntity = orderRepository.saveOrder(shoppingCart, orderRequest);
        return new OrderRecord(orderEntity.getId(), orderRequest.userId(), orderRequest.storeId(), shoppingCart.menus());
    }
}
