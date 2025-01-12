package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.web.OrderRequest;
import org.springframework.stereotype.Service;

@org.jmolecules.ddd.annotation.Service
@Service
public class OrderRepositoryImpl implements OrderRepository {
//    private final OrderDomainRepository orderDomainRepository;

    public OrderEntity saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest) {
        return new OrderEntity();// TODO;
    }
}
