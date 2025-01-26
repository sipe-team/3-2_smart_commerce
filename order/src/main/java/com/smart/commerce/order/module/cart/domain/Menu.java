package com.smart.commerce.order.module.cart.domain;

public record Menu(
        Long storeId,
        Long menuId,
        String menuName,
        int price
) {

}
