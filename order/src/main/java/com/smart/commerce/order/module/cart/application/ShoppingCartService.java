package com.smart.commerce.order.module.cart.application;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCart;
import com.smart.commerce.order.module.order.application.port.out.ShoppingCartPort;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService implements ShoppingCartPort {

    @Override
    public ShoppingCart getItems(Long customerId) {
        return new ShoppingCart(1L, 100L, null); // TODO 허정화님
    }
}
