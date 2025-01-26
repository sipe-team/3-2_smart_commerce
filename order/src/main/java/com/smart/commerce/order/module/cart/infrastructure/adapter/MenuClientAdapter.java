package com.smart.commerce.order.module.cart.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.Menu;
import com.smart.commerce.order.module.cart.domain.MenuClient;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MenuClientAdapter implements MenuClient {

    @Override
    public Optional<Menu> findById(final Long id) {
        return Optional.empty();
    }
}
