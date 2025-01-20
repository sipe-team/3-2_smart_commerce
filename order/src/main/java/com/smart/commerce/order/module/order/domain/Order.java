package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.infrastructure.OrderRequest;
import org.jmolecules.ddd.annotation.AggregateRoot;

@AggregateRoot
public class Order {

    public void checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest) {
    }
}
