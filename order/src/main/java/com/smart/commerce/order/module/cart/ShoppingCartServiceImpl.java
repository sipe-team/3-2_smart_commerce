package com.smart.commerce.order.module.cart;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Override
    public void clearCart() {
    }

    @Override
    public void order() {
    }

    @Override
    public ShoppingCart getItems(int userId) {
        return new ShoppingCart(List.of());
    }
}
