package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.dto.OrderRequest;
import com.smart.commerce.order.module.order.domain.model.Order;
import com.smart.commerce.order.module.order.entity.OrderEntity;
import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface OrderRepository {

    void checkOrderValid(ShoppingCart shoppingCart, OrderRequest orderRequest);

    OrderEntity save(ShoppingCart shoppingCart, OrderRequest orderRequest);
}
