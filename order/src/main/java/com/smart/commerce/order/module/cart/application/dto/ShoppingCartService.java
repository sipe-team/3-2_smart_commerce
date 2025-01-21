package com.smart.commerce.order.module.cart.application.dto;

import com.smart.commerce.order.module.order.application.port.ShoppingCartPort;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService implements ShoppingCartPort {

    @Override
    public ShoppingCart getItems(Long userId) {
        return null;
    }
}
