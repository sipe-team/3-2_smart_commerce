package com.smart.commerce.order.module.cart.domain;

import java.util.Optional;

public interface MenuClient {

    Optional<Menu> findById(Long menuId);
}
