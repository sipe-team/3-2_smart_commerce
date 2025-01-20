package com.smart.commerce.order.module.order.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.infrastructure.OrderRequest;


public interface OrderAdapter {

    OrderEntity saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest);
}
