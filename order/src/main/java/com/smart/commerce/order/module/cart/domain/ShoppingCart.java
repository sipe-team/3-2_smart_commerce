package com.smart.commerce.order.module.cart.domain;

public class ShoppingCart {

    private final Long customerId;

    private Long storeId;

    private final OrderLines orderLines;

    public ShoppingCart(final Long customerId, final Long storeId) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.orderLines = new OrderLines();
    }

    public boolean canAddToCart(Menu menu) {
        return this.storeId.equals(menu.storeId());
    }

    public void add(final Menu menu) {
        if (!canAddToCart(menu)) {
            this.storeId = menu.storeId();
            orderLines.clear();
        }
        orderLines.add(menu.menuId());
    }

    public void minus(final Menu menu) {
        orderLines.minus(menu.menuId());
    }

    public void delete(final Long menuId) {
        orderLines.remove(menuId);
    }
}
