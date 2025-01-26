package com.smart.commerce.order.module.cart;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCartSnapshot;

public interface ShoppingCartService {
    void clearCart();

    void order();

    //    void setStore(Commodity store);
    ShoppingCartSnapshot getItems(int customerId);
}
