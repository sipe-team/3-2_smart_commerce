package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface OrderRepository {

    Order getOrderById(Long orderId);

    boolean checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest);

    Order save(ShoppingCart shoppingCart, OrderRequest orderRequest);
}
