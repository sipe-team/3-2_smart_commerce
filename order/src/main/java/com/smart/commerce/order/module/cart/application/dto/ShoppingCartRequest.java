package com.smart.commerce.order.module.cart.application.dto;

public record ShoppingCartRequest(
        Long customerId,
        Long menuId
) {

}
