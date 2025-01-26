package com.smart.commerce.order.module.cart.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.cart.domain.ShoppingCartRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    @Override
    public Optional<ShoppingCart> findByCustomerId(final Long customerId) {
        return Optional.empty();
    }

    @Override
    public void save(final ShoppingCart cart) {

    }
}
