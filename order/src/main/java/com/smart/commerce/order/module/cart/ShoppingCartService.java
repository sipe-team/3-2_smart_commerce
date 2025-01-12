package com.smart.commerce.order.module.cart;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.menu.Menu;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    void addItem(Menu commodity);
    void removeItem(Menu commodity);
    void clearCart();

    void order();

    //    void setStore(Commodity store);
    ShoppingCart getItems(int userId);
}
