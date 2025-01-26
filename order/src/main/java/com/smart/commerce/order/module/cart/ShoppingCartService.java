package com.smart.commerce.order.module.cart;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;

public interface ShoppingCartService {
    void clearCart();

    void order();

    //    void setStore(Commodity store);
    ShoppingCart getItems(int customerId);
}
