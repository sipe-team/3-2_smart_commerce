package com.smart.commerce.order.module.order.application;

import com.smart.commerce.order.module.cart.ShoppingCartService;
import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.domain.OrderRecord;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.infrastructure.adapter.OrderAdapter;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderStatus;
import com.smart.commerce.order.module.order.infrastructure.listener.event.OrderToPaymentEvent;
import com.smart.commerce.order.module.order.infrastructure.OrderRequest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    private final ApplicationEventPublisher events;
    private final ShoppingCartService shoppingCartService;
    private final OrderAdapter orderAdapter;

    public OrderServiceImpl(ApplicationEventPublisher events, ShoppingCartService shoppingCartService, OrderAdapter orderAdapter) {
        this.events = events;
        this.shoppingCartService = shoppingCartService;
        this.orderAdapter = orderAdapter;
    }

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
        OrderEntity orderEntity = orderAdapter.saveOrder(shoppingCart, orderRequest);
        return new OrderRecord(orderEntity.getId(), orderRequest.userId(), orderRequest.storeId(), shoppingCart.menus());
    }
}
