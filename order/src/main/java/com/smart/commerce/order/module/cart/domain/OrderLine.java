package com.smart.commerce.order.module.cart.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class OrderLine {

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
}
