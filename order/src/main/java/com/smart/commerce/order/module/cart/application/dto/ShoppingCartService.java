package com.smart.commerce.order.module.cart.application.dto;

import com.smart.commerce.order.module.order.domain.ShoppingCartPort;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService implements ShoppingCartPort {
    @Override
    public ShoppingCart getItems(int userId) {
        return null;
    }
}
