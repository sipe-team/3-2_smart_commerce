package com.smart.commerce.order.module.cart.domain;

import java.util.Optional;

public interface ShoppingCartRepository {

    Optional<ShoppingCart> findByCustomerId(Long customerId);

    void save(ShoppingCart cart);
}
