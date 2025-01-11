package com.smart.commerce.order.module.cart;

import com.smart.commerce.order.module.commodity.Commodity;
import com.smart.commerce.order.module.menu.Menu;

import java.util.List;

public interface ShoppingCartService {
    void addItem(Menu commodity);
    void removeItem(Menu commodity);
    void clearCart();

    void order();

    //    void setStore(Commodity store);
    List<Menu> getItems(int userId);
}
