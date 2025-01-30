package com.smart.commerce.order.module.cart.domain;

import com.smart.commerce.order.module.cart.application.exception.NotFoundMenuException;
import java.util.Map;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class OrderLine {

    @Getter
    private final Long menuId;
    private int quantity;

    public OrderLine(final Long menuId) {
        this.menuId = menuId;
        this.quantity = 1;
    }

    public void add() {
        quantity++;
    }

    public void minus() {
        quantity--;
        if (quantity == 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEqualsMenu(final Long menuId) {
        return this.menuId.equals(menuId);
    }

    public Long getAmount(Map<Long, Menu> menus) {
        return Optional.ofNullable(menus.get(menuId))
                .map(menu -> (long) menu.price() * quantity)
                .orElseThrow(() -> new NotFoundMenuException(menuId));
    }
}
