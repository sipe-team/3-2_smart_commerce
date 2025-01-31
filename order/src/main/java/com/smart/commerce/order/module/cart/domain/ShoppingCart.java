package com.smart.commerce.order.module.cart.domain;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShoppingCart {

    private Long customerId;

    private Long storeId;

    private OrderLines orderLines;

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

    public List<Long> menuIds() {
        return orderLines.menuIds();
    }

    public Long calculateAmount(Map<Long, Menu> menus) {
        return orderLines.calculateAmount(menus);
    }
}
