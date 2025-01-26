package com.smart.commerce.order.module.order.application.port.out;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCartSnapshot;

public interface ShoppingCartPort {
    ShoppingCartSnapshot getItems(Long customerId);
}
