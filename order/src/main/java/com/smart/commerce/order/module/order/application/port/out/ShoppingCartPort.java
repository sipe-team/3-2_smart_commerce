package com.smart.commerce.order.module.order.application.port.out;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;

public interface ShoppingCartPort {
    ShoppingCart getItems(Long customerId);
}
