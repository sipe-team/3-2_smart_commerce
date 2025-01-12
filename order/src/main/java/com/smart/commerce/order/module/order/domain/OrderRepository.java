package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import com.smart.commerce.order.module.order.web.OrderRequest;


public interface OrderRepository {

    OrderEntity saveOrder(ShoppingCart shoppingCart, OrderRequest orderRequest);
}
