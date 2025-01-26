package com.smart.commerce.order.module.order.application.port;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;

public interface ShoppingCartPort {

    ShoppingCart findByCustomerId(Long customerId);
}
