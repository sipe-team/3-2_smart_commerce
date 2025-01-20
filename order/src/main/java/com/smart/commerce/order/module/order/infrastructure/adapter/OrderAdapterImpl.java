package com.smart.commerce.order.module.order.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.infrastructure.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderAdapterImpl implements OrderAdapter {
//    private final OrderDomainRepository orderDomainRepository;

    public OrderEntity saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        return new OrderEntity();// TODO;
    }
}
