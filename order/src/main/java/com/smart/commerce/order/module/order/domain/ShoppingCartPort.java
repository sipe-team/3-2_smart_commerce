package com.smart.commerce.order.module.order.domain;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;

public interface ShoppingCartPort {
    ShoppingCart getItems(int userId);
}
